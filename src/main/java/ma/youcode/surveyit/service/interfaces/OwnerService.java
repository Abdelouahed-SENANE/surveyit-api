package ma.youcode.surveyit.service.interfaces;

import ma.youcode.surveyit.dto.request.owner.OwnerRequestDTO;
import ma.youcode.surveyit.dto.response.owner.OwnerResponseDTO;
import ma.youcode.surveyit.entity.Owner;
import org.springframework.data.domain.Page;

public interface OwnerService {
    Page<OwnerResponseDTO> getAllOwners(int page , int size);
    OwnerResponseDTO getOwner(Long id);
    void create(OwnerRequestDTO dto);
    OwnerResponseDTO editOwner(OwnerRequestDTO dto , Long id);
    void deleteOwner(Long id);
    Owner getOwnerEntity(Long id);


}
