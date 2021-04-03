package com.swedbank.academy.evaluationplatform.evaluation;

import com.swedbank.academy.evaluationplatform.evaluation.exceptions.EvaluationNotFoundException;
import com.swedbank.academy.evaluationplatform.mentor.Mentor;
import com.swedbank.academy.evaluationplatform.student.Student;

public interface EvaluationService {
    public Evaluation getEvaluation(long id) throws EvaluationNotFoundException;
    public void createEvaluation(EvaluationDTO evaluationFormDTO, Mentor mentor, Student student);
    public EvaluationDTO getEvaluationByIds(long mentor_id, long student_id) throws EvaluationNotFoundException;
    public boolean checkIfEvaluationExists(long mentorId, long studentId);
    public JointEvaluationDTO getJointEvaluation(long studentId);
    public void updateEvaluation(EvaluationDTO evaluationDTO, Mentor mentor, Student student, long id);
    public boolean deleteEvaluation(EvaluationDTO evaluationDTO, long mentor_id, long student_id);
}
