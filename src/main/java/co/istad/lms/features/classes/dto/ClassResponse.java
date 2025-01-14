package co.istad.lms.features.classes.dto;

import co.istad.lms.domain.Generation;
import co.istad.lms.domain.Shift;
import co.istad.lms.domain.StudyProgram;
import co.istad.lms.domain.roles.Instructor;
import co.istad.lms.domain.roles.Student;

import java.util.Set;

public record ClassResponse(

        String alias,
        String className,

        Instructor instructor,
        StudyProgram studyProgram,
        Shift shift,
        Generation generation,
        Set<Student> students
) {
}
