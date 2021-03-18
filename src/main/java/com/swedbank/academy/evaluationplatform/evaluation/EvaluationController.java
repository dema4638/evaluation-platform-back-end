package com.swedbank.academy.evaluationplatform.evaluation;

import com.swedbank.academy.evaluationplatform.mentor.Mentor;
import com.swedbank.academy.evaluationplatform.mentor.MentorService;
import com.swedbank.academy.evaluationplatform.student.Student;
import com.swedbank.academy.evaluationplatform.student.StudentService;
import com.swedbank.academy.evaluationplatform.student.exception.StudentNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/evaluation")
public class EvaluationController {

    EvaluationService evaluationService;
    MentorService mentorService;
    StudentService studentService;

    public EvaluationController(EvaluationService evaluationService, MentorService mentorService, StudentService studentService) {
        this.evaluationService = evaluationService;
        this.mentorService = mentorService;
        this.studentService = studentService;
    }

    @PostMapping(consumes = "application/json",produces = "application/json")
    @CrossOrigin(origins ="*", allowedHeaders ="*", methods = RequestMethod.POST)
    public ResponseEntity<?>createEvaluation(@RequestBody EvaluationDTO evaluationDTO) throws StudentNotFoundException {
        Mentor mentor = mentorService.getMentor(evaluationDTO.getMentorID());
        Student student = studentService.getStudent(evaluationDTO.getStudentId());
        evaluationService.createEvaluation(evaluationDTO, mentor, student);
        return ResponseEntity.ok().build();
        }
}
