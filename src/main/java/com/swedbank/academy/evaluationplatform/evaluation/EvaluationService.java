package com.swedbank.academy.evaluationplatform.evaluation;

import com.swedbank.academy.evaluationplatform.mentor.Mentor;
import com.swedbank.academy.evaluationplatform.student.Student;

public interface EvaluationService {
    public Evaluation getEvaluation(long id);
    public void createEvaluation(EvaluationDTO evaluationFormDTO, Mentor mentor, Student student);
    public EvaluationDTO getEvaluationByIds(long mentor_id, long student_id);
    public boolean checkIfEvaluationExists(long mentorId, long studentId);

}
