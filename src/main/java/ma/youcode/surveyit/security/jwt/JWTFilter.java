package ma.youcode.surveyit.security.jwt;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.HandlerExceptionResolver;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JWTFilter extends OncePerRequestFilter {

    private final HandlerExceptionResolver handlerExceptionResolver;
    private final JWTGenerator jwtGenerator;
    private final UserDetailsService userDetailsService;
    private static final String BEARER = "Bearer ";

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        final String authHeader = request.getHeader("Authorization");
        if (authHeader == null || !authHeader.startsWith(BEARER)) {
            filterChain.doFilter(request, response);
            return;
        }

        try {
            final String token = extractToken(request);
            final String username = jwtGenerator.extractUsername(token);

            if (token != null && jwtGenerator.verifyToken(token)) {
                authenticateUser(request , token , username);
            }
            filterChain.doFilter(request, response);
        } catch (Exception e) {
            handlerExceptionResolver.resolveException(request, response, null, e);
        }
    }

    private String extractToken(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");

        if (bearerToken != null && bearerToken.startsWith(BEARER)) {
            return bearerToken.substring(BEARER.length());
        }
        return null;
    }


    private void authenticateUser(HttpServletRequest request, String jwt, String username) {
        if (isUserAlreadyAuthenticated()) {
            return;
        }

        UserDetails userDetails = loadUserDetails(username);

        if (isValidToken(jwt, userDetails)) {
            setAuthenticatedUser(request, userDetails);
        } else {
            throw new IllegalArgumentException("Invalid Jwt token for user " + username);
        }
    }

    private boolean isUserAlreadyAuthenticated() {
        Authentication currentUser = SecurityContextHolder.getContext().getAuthentication();
        return currentUser != null && currentUser.isAuthenticated();
    }

    private UserDetails loadUserDetails(String username) {
        return userDetailsService.loadUserByUsername(username);
    }

    private boolean isValidToken(String jwt, UserDetails userDetails) {
        return jwtGenerator.isTokenValid(jwt, userDetails);
    }

    private void setAuthenticatedUser(HttpServletRequest request, UserDetails userDetails) {
        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                userDetails, null, userDetails.getAuthorities()
        );
        authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        SecurityContextHolder.getContext().setAuthentication(authToken);
    }
}