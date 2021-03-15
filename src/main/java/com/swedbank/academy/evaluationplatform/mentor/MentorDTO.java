package com.swedbank.academy.evaluationplatform.mentor;

public class MentorDTO {

    private long id;
    private String name;
    private Stream stream;

    public MentorDTO(long id, String name, Stream stream) {
        this.id = id;
        this.name = name;
        this.stream = stream;
    }
}
