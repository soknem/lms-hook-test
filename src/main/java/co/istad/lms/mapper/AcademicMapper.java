package co.istad.lms.mapper;


import co.istad.lms.domain.roles.Academic;
import co.istad.lms.features.academic.dto.AcademicRequest;
import co.istad.lms.features.academic.dto.AcademicResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AcademicMapper {

    Academic toRequest(AcademicRequest academicRequest);


    @Mapping(source = "user", target = "users")
    AcademicResponse toResponse(Academic academic);

}
