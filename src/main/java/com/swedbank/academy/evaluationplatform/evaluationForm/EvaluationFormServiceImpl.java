package com.swedbank.academy.evaluationplatform.evaluationForm;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class EvaluationFormServiceImpl implements EvaluationFormService{

    private EvaluationFormRepository evaluationFormRepository;

    public EvaluationFormServiceImpl(EvaluationFormRepository evaluationFormRepository) {
        this.evaluationFormRepository = evaluationFormRepository;
    }

    @Override
    public EvaluationForm getEvaluationForm(long id) {

        return evaluationFormRepository.findById(id).get();
    }

    @Override
    public void createEvaluationForm(EvaluationForm evaluationForm) {
        evaluationFormRepository.save(evaluationForm);
    }

    @Override
    public EvaluationFormDTO getEvaluationFormByIds(long mentor_id, long student_id) {
        List<EvaluationForm> evaluationForms = evaluationFormRepository.findAll();
        for (EvaluationForm evaluation : evaluationForms) {
            if (evaluation.getStudentMentor().getStudent().getId()==student_id){
                if (evaluation.getStudentMentor().getMentor().getId()==mentor_id){

                    return getEvaluationFormDTO(evaluation);
                }
            }
        }
        return null;
    }

    public EvaluationFormDTO getEvaluationFormDTO(EvaluationForm evaluationForm){
        long formId= evaluationForm.getId();
        int participation = evaluationForm.getParticipation();
        int techSkills = evaluationForm.getTechSkills();
        int learningPace = evaluationForm.getLearningPace();
        int extraMile = evaluationForm.getExtraMile();
        String comment = evaluationForm.getComment();
        long studentId = evaluationForm.getStudentMentor().getStudent().getId();
        long mentorId = evaluationForm.getStudentMentor().getMentor().getId();
        EvaluationFormDTO evaluationFormDTO = new EvaluationFormDTO(formId, mentorId, participation, techSkills, learningPace, extraMile, comment, studentId);
        return evaluationFormDTO;
    }
}
