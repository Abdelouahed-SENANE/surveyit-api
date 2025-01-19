package ma.youcode.surveyit.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "owners")
@SuperBuilder(toBuilder = true)
@Getter
@Setter
@NoArgsConstructor
@DiscriminatorValue("ROLE_OWNER")
@AllArgsConstructor
public class Owner extends User{

    @OneToMany(mappedBy = "owner" , fetch = FetchType.EAGER)
    private List<Survey> surveys = new ArrayList<>();

}
