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

    public static Stream getStream(String stream){
        Stream streamEnum = BACKEND;
        switch (stream){
            case "Front-end":
                streamEnum=FRONTEND;
                break;
            case "QA":
                streamEnum=QA;
                break;
        }
        return streamEnum;
    }
}