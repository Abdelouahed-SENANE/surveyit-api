package ma.youcode.surveyit.mapper;

import ma.youcode.surveyit.dto.request.owner.OwnerRequestDTO;
import ma.youcode.surveyit.dto.response.owner.OwnerEmbeddedDTO;
import ma.youcode.surveyit.dto.response.owner.OwnerResponseDTO;
import ma.youcode.surveyit.entity.Owner;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OwnerMapper {

    @Mapping(source = "id" , target = "userInfo.id")
    @Mapping(source = "id" , target = "userInfo.name")
    @Mapping(source = "id" , target = "userInfo.email")
    OwnerResponseDTO toResponseDTO(Owner owner);
    OwnerEmbeddedDTO toEmbeddedDTO(Owner owner);

    @Mapping(source = "userInfo.name" , target = "name")
    @Mapping(source = "userInfo.email" , target = "email")
    @Mapping(source = "userInfo.password" , target = "password")
    Owner toOwner(OwnerRequestDTO dto);


}
