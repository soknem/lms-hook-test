package co.istad.lms.features.material.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record MaterialRequest(

        @NotBlank(message = "Alias is required")
        @Size(max = 50, message = "Alias cannot be longer than 50 characters")
        String alias,
        @NotBlank(message = "Title is required")
        @Size(max = 50, message = "Title cannot be longer than 50 characters")
        String title,
        String contentType,
        String extension,
        Long size,
        @NotBlank(message = "File URL is required")
        String fileUrl,
        String thumbnail,
        String description,
        @NotBlank(message = "Subject alias is required")
        String subjectAlias

) {
}


