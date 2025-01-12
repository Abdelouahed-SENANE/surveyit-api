package ma.youcode.surveyit.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@SuperBuilder(toBuilder = true)
@Getter
@Setter
@AllArgsConstructor
@DiscriminatorValue("ROLE_ADMIN")
@Table(name = "admins")
public class Admin extends User{
}
