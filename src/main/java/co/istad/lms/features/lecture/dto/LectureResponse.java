package co.istad.lms.features.lecture.dto;

public record LectureResponse(

        String alias,
        String startTime,
        String endTime,
        String description,
        String lectureDate,
        String courseAlias

) {
}
