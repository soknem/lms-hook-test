package co.istad.lms.features.instructor;

import co.istad.lms.features.instructor.dto.InstructorRequest;
import co.istad.lms.features.instructor.dto.InstructorResponse;
import org.springframework.data.domain.Page;

public interface InstructorService {

    InstructorResponse createInstructor( InstructorRequest instructorRequest);

    InstructorResponse updateInstructorByUuid( String uuid , InstructorRequest instructorRequest);

    InstructorResponse getInstructorByUuid( String uuid);

    void deleteInstructorByUuid( String uuid);

    InstructorResponse disableInstructorByUuid( String uuid);

    InstructorResponse enableInstructorByUuid( String uuid);

    InstructorResponse blockInstructorByUuid( String uuid);

    Page<InstructorResponse> getAllInstructor(int page, int limit);


}
