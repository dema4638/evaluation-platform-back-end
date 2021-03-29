package com.swedbank.academy.evaluationplatform.student;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class StudentDTO {
    private long id;
    private String name;
    private String image;
    private boolean isEvaluated;
    private String contractType;
    private List<String> preferences = new ArrayList<String>() {
    };

    public StudentDTO(long id, String name, String image,boolean isEvaluated, String contractType, List<String> preferences) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.isEvaluated=isEvaluated;
        this.preferences = preferences;
        this.contractType = contractType;
    }


    public StudentDTO(long id, String name, String image, String contractType, List<String> preferences) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.contractType = contractType;
        this.preferences = preferences;
    }


    @JsonCreator
    public StudentDTO(String name, String image, String contractType, List<String> preferences) {
        this.name = name;
        this.image = image;
        this.contractType = contractType;
        this.preferences = preferences;
    }
}
