package com.swedbank.academy.evaluationplatform.mentor;

import lombok.Data;

@Data
public class MentorStudentDTO {
    private long id;
    private String name;
    private String img;
    private boolean isEvaluated;

    public MentorStudentDTO(long id, String name, String img, boolean isEvaluated) {
        this.id = id;
        this.name = name;
        this.img = img;
        this.isEvaluated = isEvaluated;
    }

}
