package com.swedbank.academy.evaluationplatform.lecturer;

public enum Area {

    BACKEND("backEnd"), FRONTEND("frontEnd"), QUALITY_ASSURANCE("QA");

    private String displayValue;

    Area(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}
