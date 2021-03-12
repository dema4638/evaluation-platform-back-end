package com.swedbank.academy.evaluationplatform.mentor;

public enum Stream {

    BACKEND("backEnd"), FRONTEND("frontEnd"), QUALITY_ASSURANCE("QA");

    private String displayValue;

    Stream(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}
