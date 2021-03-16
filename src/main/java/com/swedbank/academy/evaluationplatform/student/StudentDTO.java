package com.swedbank.academy.evaluationplatform.student;

import lombok.Data;

@Data
public class StudentDTO {
    private long id;
    private String name;
    private String image;

    public StudentDTO(long id, String name, String image) {
        this.id = id;
        this.name = name;
        this.image = image;
    }
}
