package com.swedbank.academy.evaluationplatform.student;

import com.swedbank.academy.evaluationplatform.evaluation.EvaluationService;
import com.swedbank.academy.evaluationplatform.student.exception.StudentNotFoundException;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class StudentServiceImpl implements StudentService {
    private StudentRepository studentRepository;
    private EvaluationService evaluationService;

    public StudentServiceImpl(StudentRepository studentRepository, EvaluationService evaluationService) {
        this.studentRepository = studentRepository;
        this.evaluationService = evaluationService;
    }

    @Override
    public StudentDTO getStudentByID(long id) throws StudentNotFoundException {
        Student student;
        try {
            student = studentRepository.findById(id).get();
            return new StudentDTO(student.getId(), student.getName(), student.getImage());
        } catch (NoSuchElementException e) {
            throw new StudentNotFoundException("Student with given ID does not exist");
        }
    }

    @Override
    public Student getStudent(long id) throws StudentNotFoundException {
        Student student;
        try {
            student = studentRepository.findById(id).get();
            return student;
        } catch (NoSuchElementException e) {
            throw new StudentNotFoundException("Student with given ID does not exist");
        }
    }

    public List<StudentDTO> getAllStudents(){
        List<Student> students = studentRepository.findAll();
        List<StudentDTO> studentsDTO = new ArrayList<>();
        for (Student student: students){
            studentsDTO.add(getStudentDTO(student));
        }
        return studentsDTO;
    }

    @Override
    public List<StudentDTO> getEvaluatedStudents(long mentorId) {
        List<Student> students = studentRepository.findAll();
        List<StudentDTO> evaluatedStudents = new ArrayList<>();
        for (Student student : students) {
            if (evaluationService.checkIfEvaluationExists(mentorId, student.getId())) {
                System.out.println("yes");
                evaluatedStudents.add(getStudentDTO(student));
            }
        }
        return evaluatedStudents;
    }

    @Override
    public List<StudentDTO> getNotEvaluatedStudents(long mentorId) {
        List<Student> students = studentRepository.findAll();
        List<StudentDTO> notEvaluatedStudentsDTO = new ArrayList<>();
        for (Student student : students) {
            if (!evaluationService.checkIfEvaluationExists(mentorId, student.getId())) {
                notEvaluatedStudentsDTO.add(getStudentDTO(student));
            }
        }
        return notEvaluatedStudentsDTO;
    }

    @Override
    public StudentDTO getStudentDTO(@Valid Student student) {
        String name = student.getName();
        String image = student.getImage();
        long id = student.getId();
        return new StudentDTO(id, name, image);

    }

}