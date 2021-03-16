package com.swedbank.academy.evaluationplatform.student;

import com.swedbank.academy.evaluationplatform.student.exception.StudentNotFoundException;

public interface StudentService {

    public StudentDTO getStudentByID(long id) throws StudentNotFoundException;
}
