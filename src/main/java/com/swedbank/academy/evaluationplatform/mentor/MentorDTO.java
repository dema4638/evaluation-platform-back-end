package com.swedbank.academy.evaluationplatform.mentor;

import lombok.Getter;

@Getter
public class MentorDTO {

    private long id;
    private String name;
    private Stream stream;

    public MentorDTO(long id, String name, Stream stream) {
        this.id = id;
        this.name = name;
        this.stream = stream;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Stream getStream() {
        return stream;
    }
}
