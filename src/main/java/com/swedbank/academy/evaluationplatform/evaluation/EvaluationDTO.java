package com.swedbank.academy.evaluationplatform.evaluation;

import com.fasterxml.jackson.annotation.JsonCreator;

public class EvaluationDTO {
    private Long id;
    private long mentorID;
    private int participation;
    private int techSkills;
    private int learningPace;
    private int extraMile;
    private String comment;
    private long studentId;

    @JsonCreator
    public EvaluationDTO(long mentorID, int participation, int techSkills, int learningPace, int extraMile, String comment, long studentId) {
        this.mentorID = mentorID;
        this.participation = participation;
        this.techSkills = techSkills;
        this.learningPace = learningPace;
        this.extraMile = extraMile;
        this.comment = comment;
        this.studentId = studentId;
    }

    public EvaluationDTO(Long formId, long mentorID, int participation, int techSkills, int learningPace, int extraMile, String comment, long studentId) {
        this(mentorID, participation, techSkills, learningPace, extraMile, comment, studentId);
        this.id = formId;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setMentorID(long mentorID) {
        this.mentorID = mentorID;
    }

    public void setParticipation(int participation) {
        this.participation = participation;
    }

    public void setTechSkills(int techSkills) {
        this.techSkills = techSkills;
    }

    public void setLearningPace(int learningPace) {
        this.learningPace = learningPace;
    }

    public void setExtraMile(int extraMile) {
        this.extraMile = extraMile;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }
}
