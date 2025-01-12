package ma.youcode.surveyit.mapper;

import ma.youcode.surveyit.dto.request.admin.AdminRequestDTO;
import ma.youcode.surveyit.dto.response.owner.OwnerEmbeddedDTO;
import ma.youcode.surveyit.dto.response.owner.OwnerResponseDTO;
import ma.youcode.surveyit.entity.Admin;
import ma.youcode.surveyit.entity.Owner;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AdminMapper {

    @Mapping(source = "id" , target = "userInfo.id")
    @Mapping(source = "name" , target = "userInfo.name")
    @Mapping(source = "email" , target = "userInfo.email")
    OwnerResponseDTO toResponseDTO(Admin admin);
    OwnerEmbeddedDTO toEmbeddedDTO(Admin admin);

    @Mapping(source = "userInfo.name" , target = "name")
    @Mapping(source = "userInfo.email" , target = "email")
    @Mapping(source = "userInfo.password" , target = "password")
    Owner toAdmin(AdminRequestDTO dto);


}
