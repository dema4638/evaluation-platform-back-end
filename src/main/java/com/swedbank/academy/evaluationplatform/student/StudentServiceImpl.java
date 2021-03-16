package com.swedbank.academy.evaluationplatform.student;

import com.swedbank.academy.evaluationplatform.student.exception.StudentNotFoundException;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class StudentServiceImpl implements StudentService {
    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
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
}