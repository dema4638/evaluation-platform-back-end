package com.swedbank.academy.evaluationplatform.evaluationForm;

import org.springframework.stereotype.Service;

@Service
public class EvaluationFormServiceImpl implements EvaluationFormService{

    private EvaluationFormRepository evaluationFormRepository;

    public EvaluationFormServiceImpl(EvaluationFormRepository evaluationFormRepository) {
        this.evaluationFormRepository = evaluationFormRepository;
    }

    @Override
    public EvaluationForm getEvaluationForm(long id) {
        return null;
    }

    @Override
    public void createEvaluationForm(EvaluationForm evaluationForm) {
        evaluationFormRepository.save(evaluationForm);
    }
}
