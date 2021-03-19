package com.swedbank.academy.evaluationplatform.mentor;

public enum Stream {

    Back_End("Back-End"), Front_End("Front-End"), Quality_Assurance("Quality Assurance");

    private String displayValue;

    Stream(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}