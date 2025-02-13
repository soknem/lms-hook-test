package co.istad.lms.features.admission.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record AdmissionCreateRequest(
        @NotBlank(message = "Name (English) is required")
        @Size(max = 50, message = "Name (English) cannot be longer than 50 characters")
        String nameEn,

        @NotBlank(message = "Name (Khmer) is required")
        @Size(max = 50, message = "Name (Khmer) cannot be longer than 50 characters")
        String nameKh,

        @NotBlank(message = "Email is required")
        @Email(message = "Email should be valid")
        @Size(max = 50, message = "Email cannot be longer than 50 characters")
        String email,

        @Size(max = 50, message = "phoneNumber cannot be longer than 50 characters")
        String phoneNumber,

        @NotNull(message = "Date of Birth is required")
        LocalDate dob,

        String pob,

        @Size(max = 10)
        String bacIiGrade,

        @NotBlank(message = "Gender is required")
        @Size(max = 20, message = "Gender cannot be longer than 20 characters")
        String gender,

        String avatar,

        String address,

        @Size(max = 50, message = "Family Phone Number cannot be longer than 50 characters")
        String familyPhoneNumber,

        String biography,

        @NotBlank(message = "Shift  alias required")
        String shiftAlias,

        @NotBlank(message = "Study Program alias is required")
        String studyProgramAlias,

        @NotBlank(message = "Degree alias is required")
        String degreeAlias
) {
}
