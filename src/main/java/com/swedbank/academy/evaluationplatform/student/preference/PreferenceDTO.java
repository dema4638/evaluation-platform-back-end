package com.swedbank.academy.evaluationplatform.student.preference;

public class PreferenceDTO {

    private long id;
    private String preference;

    public PreferenceDTO(long id, String preference) {
        this.id = id;
        this.preference = preference;
    }

    public long getId() {
        return id;
    }

    public String getPreference() {
        return preference;
    }
}
