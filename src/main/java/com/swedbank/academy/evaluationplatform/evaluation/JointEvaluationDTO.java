package com.swedbank.academy.evaluationplatform.evaluation;

import java.util.List;

public class JointEvaluationDTO {

    private long studentId;

    QAEvaluationDTO qaEvaluationDTO;


    BEEvaluationDTO beEvaluationDTO;


    FEEvaluationDTO feEvaluationDTO;

    public JointEvaluationDTO(long studentId, QAEvaluationDTO qaEvaluationDTO, BEEvaluationDTO beEvaluationDTO, FEEvaluationDTO feEvaluationDTO) {
        this.studentId = studentId;
        this.qaEvaluationDTO = qaEvaluationDTO;
        this.beEvaluationDTO = beEvaluationDTO;
        this.feEvaluationDTO = feEvaluationDTO;
    }

    public long getStudentId() {
        return studentId;
    }

    public QAEvaluationDTO getQaEvaluationDTO() {
        return qaEvaluationDTO;
    }

    public BEEvaluationDTO getBeEvaluationDTO() {
        return beEvaluationDTO;
    }

    public FEEvaluationDTO getFeEvaluationDTO() {
        return feEvaluationDTO;
    }
}
