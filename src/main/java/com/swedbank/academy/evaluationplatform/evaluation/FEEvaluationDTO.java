package com.swedbank.academy.evaluationplatform.evaluation;

import java.util.List;

public class FEEvaluationDTO{
    private double participation;
    private double techSkills;
    private double learningPace;
    private double extraMile;
    private List<String> comments;
    private double evaluationsCount;
    private double jointEvaluation;

    public FEEvaluationDTO(double participation, double techSkills, double learningPace, double extraMile, List<String> comments, double evaluationsCount, double jointEvaluation) {
        this.participation = participation;
        this.techSkills = techSkills;
        this.learningPace = learningPace;
        this.extraMile = extraMile;
        this.comments = comments;
        this.evaluationsCount = evaluationsCount;
        this.jointEvaluation = jointEvaluation;
    }
}


