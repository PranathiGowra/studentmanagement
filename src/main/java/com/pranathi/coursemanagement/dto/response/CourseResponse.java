package com.pranathi.coursemanagement.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CourseResponse {

    private Long courseId;
    private String title;
    private String description;
    private String instructor;
    private Double price;
    private Integer duration;

}