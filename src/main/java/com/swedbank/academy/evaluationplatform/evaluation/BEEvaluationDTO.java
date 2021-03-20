package com.swedbank.academy.evaluationplatform.evaluation;


import java.util.List;

public class BEEvaluationDTO {

    private double participation;
    private double techSkills;
    private double learningPace;
    private double extraMile;
    private List<String> comments;
    private double evaluationsCount;
    private double jointEvaluation;

    public BEEvaluationDTO(double participation, double techSkills, double learningPace, double extraMile, List<String> comments, double evaluationsCount, double jointEvaluation) {
        this.participation = participation;
        this.techSkills = techSkills;
        this.learningPace = learningPace;
        this.extraMile = extraMile;
        this.comments = comments;
        this.evaluationsCount = evaluationsCount;
        this.jointEvaluation = jointEvaluation;
    }

    public double getParticipation() {
        return participation;
    }

    public double getTechSkills() {
        return techSkills;
    }

    public double getLearningPace() {
        return learningPace;
    }

    public double getExtraMile() {
        return extraMile;
    }

    public List<String> getComments() {
        return comments;
    }

    public double getEvaluationsCount() {
        return evaluationsCount;
    }

    public double getJointEvaluation() {
        return jointEvaluation;
    }
}
