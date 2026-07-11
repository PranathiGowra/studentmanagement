package com.pranathi.coursemanagement.dto.request;

import lombok.Data;

@Data
public class CourseRequest {

    private String title;
    private String description;
    private String instructor;
    private Double price;
    private Integer duration;

}