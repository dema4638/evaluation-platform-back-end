package com.swedbank.academy.evaluationplatform.evaluation;

import com.swedbank.academy.evaluationplatform.evaluation.exceptions.EvaluationNotFoundException;
import com.swedbank.academy.evaluationplatform.mentor.Mentor;
import com.swedbank.academy.evaluationplatform.student.Student;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class EvaluationServiceImpl implements EvaluationService {

    private EvaluationRepository evaluationFormRepository;

    public EvaluationServiceImpl(EvaluationRepository evaluationFormRepository) {
        this.evaluationFormRepository = evaluationFormRepository;
    }

    @Override
    public Evaluation getEvaluation(long id) throws EvaluationNotFoundException{
        try {
            return evaluationFormRepository.findById(id).get();
        } catch (NoSuchElementException e){
            throw new EvaluationNotFoundException("Evaluation with given ID does not exist");
        }
    }

    @Override
    public void createEvaluation(EvaluationDTO evaluationDTO, Mentor mentor, Student student) {
        String comment = evaluationDTO.getComment();
        int participation = evaluationDTO.getParticipation();
        int techSkills = evaluationDTO.getTechSkills();
        int learningPace = evaluationDTO.getLearningPace();
        int extraMile = evaluationDTO.getExtraMile();
        Evaluation evaluation = new Evaluation(participation, techSkills, learningPace, extraMile, comment, mentor, student, mentor.getStream());
        evaluationFormRepository.save(evaluation);
    }

    @Override
    public EvaluationDTO getEvaluationByIds(long mentor_id, long student_id) throws EvaluationNotFoundException {
        List<Evaluation> evaluations = evaluationFormRepository.findAll();
        for (Evaluation evaluation : evaluations) {
            if (evaluation.getStudent().getId()==student_id){
                if (evaluation.getMentor().getId()==mentor_id){
                    return getEvaluationDTO(evaluation);
                }
            }
        }
        throw new EvaluationNotFoundException("Evaluation with given IDs does not exist");
    }

    @Override
    public boolean checkIfEvaluationExists(long mentorId, long studentId) {
        List<Evaluation> evaluations = evaluationFormRepository.findAll();
        for (Evaluation evaluation: evaluations){
            if (evaluation.getStudent().getId() == studentId){
                if (evaluation.getMentor().getId() == mentorId){
                    return  true;
                }
            }
        } return false;
    }

    public EvaluationDTO getEvaluationDTO(Evaluation evaluation){
        long formId= evaluation.getId();
        int participation = evaluation.getParticipation();
        int techSkills = evaluation.getTechSkills();
        int learningPace = evaluation.getLearningPace();
        int extraMile = evaluation.getExtraMile();
        String comment = evaluation.getComment();
        long studentId = evaluation.getStudent().getId();
        long mentorId = evaluation.getMentor().getId();
        EvaluationDTO evaluationDTO = new EvaluationDTO(formId, mentorId, participation, techSkills, learningPace, extraMile, comment, studentId);
        return evaluationDTO;
    }


}
