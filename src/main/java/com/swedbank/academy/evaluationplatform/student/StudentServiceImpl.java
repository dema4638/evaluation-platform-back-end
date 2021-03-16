package com.swedbank.academy.evaluationplatform.student;

import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService{
    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public StudentDTO getStudentByID(long id) {
        Student student = studentRepository.findById(id).get();
        StudentDTO studentDTO = new StudentDTO(student.getId(), student.getName(), student.getImage());
        return studentDTO;
    }
}
