package com.swedbank.academy.evaluationplatform.mentor;

import lombok.Data;

@Data
public class MentorDTO {

    private long id;
    private String name;
    private String stream;

    public MentorDTO(long id, String name, Stream stream) {
        this.id = id;
        this.name = name;
        this.stream = stream.getDisplayValue();
    }

}
