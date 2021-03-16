package com.swedbank.academy.evaluationplatform.studentMentor;

import com.swedbank.academy.evaluationplatform.evaluationForm.EvaluationForm;
import com.swedbank.academy.evaluationplatform.mentor.Mentor;
import com.swedbank.academy.evaluationplatform.student.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentMentorServiceImpl implements StudentMentorService{

    private StudentMentorRepository studentMentorRepository;

    @Autowired
    public StudentMentorServiceImpl(StudentMentorRepository studentMentorRepository) {
        this.studentMentorRepository = studentMentorRepository;
    }

    @Override
    public List<StudentMentor> getStudentsMentor()
    { return studentMentorRepository.findAll();
    }

    @Override
    public StudentMentor getOneStudentMentor(long id) {
        return studentMentorRepository.findById(id).get();
    }

    @Override
    public StudentMentor getStudentMentorByIds(long mentorId, long studentId) {
        List<StudentMentor> studentsMentors = studentMentorRepository.findAll();
        for (StudentMentor studentMentor : studentsMentors){
            Student student = studentMentor.getStudent();
            Mentor mentor = studentMentor.getMentor();
            if ((student.getId()==studentId) && (mentor.getId()==mentorId)){
                return studentMentor;
            }
        }
        return null;
    }

    @Override
    public void addStudentMentor(StudentMentor studentMentor) {
        studentMentorRepository.save(studentMentor);
    }

    @Override
    public void updateWhenEvaluationFormWasCreated(long id){
        StudentMentor studentMentor = studentMentorRepository.getOne(id);
        Mentor mentor = studentMentor.getMentor();
        Student student = studentMentor.getStudent();
        EvaluationForm evaluationForm = studentMentor.getEvaluationForm();
        StudentMentor newStudentMentor = new StudentMentor(id, mentor, student, 1, evaluationForm);
        studentMentorRepository.deleteById(id);
        studentMentorRepository.save(newStudentMentor);
    }

}
