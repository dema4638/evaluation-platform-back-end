package com.swedbank.academy.evaluationplatform.evaluation;

import java.util.List;

public class FEEvaluationDTO{
    private Double participation;
    private Double techSkills;
    private Double learningPace;
    private Double extraMile;
    private List<String> comments;
    private Double evaluationsCount;
    private Double jointEvaluation;

    public FEEvaluationDTO(Double participation, Double techSkills, Double learningPace, Double extraMile, List<String> comments, Double evaluationsCount, Double jointEvaluation) {
        this.participation = participation;
        this.techSkills = techSkills;
        this.learningPace = learningPace;
        this.extraMile = extraMile;
        this.comments = comments;
        this.evaluationsCount = evaluationsCount;
        this.jointEvaluation = jointEvaluation;
    }

    public Double getParticipation() {
        return participation;
    }

    public Double getTechSkills() {
        return techSkills;
    }

    public Double getLearningPace() {
        return learningPace;
    }

    public Double getExtraMile() {
        return extraMile;
    }

    public List<String> getComments() {
        return comments;
    }

    public Double getEvaluationsCount() {
        return evaluationsCount;
    }

    public Double getJointEvaluation() {
        return jointEvaluation;
    }
}


