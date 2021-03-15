package com.swedbank.academy.evaluationplatform.mentor;

import com.fasterxml.jackson.annotation.JsonInclude;

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

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImg() {
        return img;
    }

    public boolean isEvaluated() {
        return isEvaluated;
    }
}
