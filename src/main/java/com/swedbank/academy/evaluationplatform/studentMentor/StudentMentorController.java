package com.swedbank.academy.evaluationplatform.studentMentor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
//@RequestMapping("api/mentor/{mentorId}/student")
//@CrossOrigin(origins ="*", allowedHeaders ="*")
public class StudentMentorController {

    private StudentMentorService studentMentorService;

    public StudentMentorController(StudentMentorService studentMentorService) {
        this.studentMentorService = studentMentorService;
    }

    @GetMapping(produces = "application/json")
    @CrossOrigin(origins ="*", allowedHeaders ="*")
    public ResponseEntity<List<StudentMentor>> getStudentsMentors(@PathVariable long mentorId) {
        List<StudentMentor> studentsMentor = studentMentorService.getStudentsMentor();
        return new ResponseEntity<List<StudentMentor>>(studentsMentor, HttpStatus.OK);
    }
}
