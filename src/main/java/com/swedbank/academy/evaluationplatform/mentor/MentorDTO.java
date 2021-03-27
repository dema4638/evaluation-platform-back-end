package com.swedbank.academy.evaluationplatform.mentor;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Data;

@Data
public class MentorDTO {

    private long id;
    private String name;
    private String stream;

    @JsonCreator
    public MentorDTO(String name, String stream) {
        this.name = name;
        this.stream = stream;
    }

    public MentorDTO(long id, String name, Stream stream) {
        this.id = id;
        this.name = name;
        this.stream = stream.getDisplayValue();
    }

}
