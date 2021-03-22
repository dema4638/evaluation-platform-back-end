package com.swedbank.academy.evaluationplatform.evaluation;

import com.swedbank.academy.evaluationplatform.mentor.Mentor;
import com.swedbank.academy.evaluationplatform.mentor.MentorService;
import com.swedbank.academy.evaluationplatform.mentor.exceptions.MentorNotFoundException;
import com.swedbank.academy.evaluationplatform.student.Student;
import com.swedbank.academy.evaluationplatform.student.StudentService;
import com.swedbank.academy.evaluationplatform.student.exception.StudentNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/evaluation")
public class EvaluationController {

    EvaluationService evaluationService;
    MentorService mentorService;
    StudentService studentService;
    EvaluationRepository evaluationRepository;

    public EvaluationController(EvaluationService evaluationService, MentorService mentorService, StudentService studentService, EvaluationRepository evaluationRepository) {
        this.evaluationService = evaluationService;
        this.mentorService = mentorService;
        this.studentService = studentService;
        this.evaluationRepository = evaluationRepository;
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    @CrossOrigin(origins = "*", allowedHeaders = "*", methods = RequestMethod.POST)
    public ResponseEntity<?> createEvaluation(@RequestBody @Valid EvaluationDTO evaluationDTO) {
        Mentor mentor;
        try {
            mentor = mentorService.getMentor(evaluationDTO.getMentorID());
        } catch (MentorNotFoundException e) {
            return ResponseEntity.badRequest().build();
        }
        try {
            Student student = studentService.getStudent(evaluationDTO.getStudentId());
            evaluationService.createEvaluation(evaluationDTO, mentor, student);
            return ResponseEntity.ok().build();
        } catch (StudentNotFoundException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    //    @PostMapping(consumes = "application/json", produces = "application/json")
//    @CrossOrigin(origins = "*", allowedHeaders = "*", methods = RequestMethod.PUT)


    @PutMapping("{id}")
    public ResponseEntity<?> updateEvaluation(@RequestBody EvaluationDTO evaluationDTO) {
        Mentor mentor;
        try {
            mentor = mentorService.getMentor(evaluationDTO.getMentorID());
        } catch (MentorNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
        try {
            Student student = studentService.getStudent(evaluationDTO.getStudentId());
            evaluationService.updateEvaluation(evaluationDTO, mentor, student);
            return ResponseEntity.ok().build();
        } catch (StudentNotFoundException e) {
            return ResponseEntity.notFound().build();
        }

    }

}
