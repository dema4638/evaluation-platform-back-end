package com.swedbank.academy.evaluationplatform.studentMentor;

import com.swedbank.academy.evaluationplatform.mentor.Mentor;

import java.util.List;

public interface StudentMentorService {

    public List<StudentMentor> getStudentsMentor();
    public StudentMentor getOneStudentMentor(long studentId);
    void addStudentMentor(StudentMentor studentMentor);
    public void updateWhenEvaluationFormWasCreated(long id);

}
