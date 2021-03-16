package com.swedbank.academy.evaluationplatform.evaluationForm;

import com.fasterxml.jackson.annotation.JsonCreator;

public class EvaluationFormDTO {
    private Long formId;
    private long mentorID;
    private int participation;
    private int techSkills;
    private int learningPace;
    private int extraMile;
    private String comment;
    private long studentId;

    @JsonCreator
    public EvaluationFormDTO(long mentorID, int participation, int techSkills, int learningPace, int extraMile, String comment, long studentId) {
        this.mentorID = mentorID;
        this.participation = participation;
        this.techSkills = techSkills;
        this.learningPace = learningPace;
        this.extraMile = extraMile;
        this.comment = comment;
        this.studentId = studentId;
    }

    public EvaluationFormDTO(Long formId, long mentorID, int participation, int techSkills, int learningPace, int extraMile, String comment, long studentId) {
        this(mentorID, participation, techSkills, learningPace, extraMile, comment, studentId);
        this.formId = formId;
    }

    public long getMentorID() {
        return mentorID;
    }


    public int getParticipation() {
        return participation;
    }

    public int getTechSkills() {
        return techSkills;
    }

    public int getLearningPace() {
        return learningPace;
    }

    public int getExtraMile() {
        return extraMile;
    }

    public String getComment() {
        return comment;
    }

    public long getStudentId() {
        return studentId;
    }

    public Long getFormId() {
        return formId;
    }

}
