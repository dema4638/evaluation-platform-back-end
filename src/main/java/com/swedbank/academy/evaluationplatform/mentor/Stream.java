package com.swedbank.academy.evaluationplatform.mentor;

public enum Stream {

    BACKEND("Back-end"), FRONTEND("Front-end"), QA("QA");

    private String displayValue;

    Stream(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}