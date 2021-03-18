package com.swedbank.academy.evaluationplatform.student;

import com.swedbank.academy.evaluationplatform.student.exception.StudentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/student")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("{id}")
    public ResponseEntity<StudentDTO> getStudent(@PathVariable long id) {
        try {
            StudentDTO studentDTO = studentService.getStudentByID(id);
            return new ResponseEntity<>(studentDTO, HttpStatus.OK);
        } catch (StudentNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
