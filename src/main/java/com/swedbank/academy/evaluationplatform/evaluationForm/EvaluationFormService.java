package com.swedbank.academy.evaluationplatform.evaluationForm;

public interface EvaluationFormService{
    public EvaluationForm getEvaluationForm(long id);
    public void createEvaluationForm(EvaluationForm evaluationForm);
    public EvaluationFormDTO getEvaluationFormByIds(long mentor_id, long student_id);

}
