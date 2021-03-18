package com.swedbank.academy.evaluationplatform.student;

import com.swedbank.academy.evaluationplatform.student.exception.StudentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
//@CrossOrigin(origins ="*", allowedHeaders ="*")
@RequestMapping("api/student")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("{id}")
    @CrossOrigin(origins ="*", allowedHeaders ="*")
    public ResponseEntity<StudentDTO> getStudent(@PathVariable long id) {
        try {
            StudentDTO studentDTO = studentService.getStudentByID(id);
            return new ResponseEntity<StudentDTO>(studentDTO, HttpStatus.OK);
        } catch (StudentNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
