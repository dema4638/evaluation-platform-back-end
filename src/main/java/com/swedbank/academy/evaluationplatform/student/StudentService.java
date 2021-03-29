package com.swedbank.academy.evaluationplatform.student;

import com.swedbank.academy.evaluationplatform.mentor.Mentor;
import com.swedbank.academy.evaluationplatform.student.exception.StudentNotFoundException;

import java.util.List;


public interface StudentService {

    public StudentDTO getStudentByID(long id) throws StudentNotFoundException;

    public List<StudentDTO> getAllStudents(Mentor mentor);

    public List<StudentDTO> getAllStudents();

    public Student getStudent(long id) throws StudentNotFoundException;

    public StudentDTO getStudentDTO(Student student, Mentor mentor);

    public void deleteStudent (long studentId);


}
