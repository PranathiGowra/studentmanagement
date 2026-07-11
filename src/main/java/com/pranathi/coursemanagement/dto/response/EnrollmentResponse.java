package com.pranathi.coursemanagement.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EnrollmentResponse {

    private Long enrollmentId;
    private String studentName;
    private String courseTitle;
    private String enrollmentDate;

}