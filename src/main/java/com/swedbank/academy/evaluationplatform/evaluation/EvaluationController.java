package com.swedbank.academy.evaluationplatform.evaluation;

import com.swedbank.academy.evaluationplatform.evaluation.exceptions.EvaluationNotFoundException;
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

    @PutMapping("/api/evaluation/{id}")
    public ResponseEntity<?> updateEvaluation(@RequestBody EvaluationDTO evaluationDTO) {

        try {
            long mentorID = evaluationDTO.getMentorID();
            long studentID = evaluationDTO.getStudentId();
            EvaluationDTO oldEvaluation = evaluationService.getEvaluationByIds(mentorID, studentID);
            evaluationService.updateEvaluation(oldEvaluation, evaluationDTO);
            return ResponseEntity.ok().build();
        } catch (EvaluationNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

}
