package com.swedbank.academy.evaluationplatform.student;

import com.swedbank.academy.evaluationplatform.evaluation.Evaluation;
import com.swedbank.academy.evaluationplatform.mentor.Mentor;
import com.swedbank.academy.evaluationplatform.student.exception.StudentNotFoundException;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface StudentService {

    public StudentDTO getStudentByID(long id) throws StudentNotFoundException;

    public List<StudentDTO> getAllStudents(Mentor mentor);

    public Student getStudent(long id) throws StudentNotFoundException;

    public StudentDTO getStudentDTO(Student student, Mentor mentor);


}
