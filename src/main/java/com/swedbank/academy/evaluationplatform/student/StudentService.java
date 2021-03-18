package com.swedbank.academy.evaluationplatform.student;

import com.swedbank.academy.evaluationplatform.student.exception.StudentNotFoundException;

import java.util.List;


public interface StudentService {

    public StudentDTO getStudentByID(long id) throws StudentNotFoundException;

    public List<StudentDTO> getAllStudents();

    public Student getStudent(long id) throws StudentNotFoundException;

    public List<StudentDTO> getEvaluatedStudents(long mentorId);

    public List<StudentDTO> getNotEvaluatedStudents(long mentorId);

    public StudentDTO getStudentDTO(Student student);

}
