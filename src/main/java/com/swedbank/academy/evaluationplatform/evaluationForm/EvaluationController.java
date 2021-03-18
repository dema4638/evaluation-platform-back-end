package com.swedbank.academy.evaluationplatform.evaluationForm;

import com.swedbank.academy.evaluationplatform.mentor.Mentor;
import com.swedbank.academy.evaluationplatform.mentor.MentorService;
import com.swedbank.academy.evaluationplatform.student.Student;
import com.swedbank.academy.evaluationplatform.student.StudentService;
import com.swedbank.academy.evaluationplatform.student.exception.StudentNotFoundException;
import org.springframework.http.HttpStatus;
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


//    @GetMapping("{id}")
//    public ResponseEntity<EvaluationDTO>getEvaluation(@PathVariable long id){
//        Evaluation evaluationForm = this.evaluationService.getEvaluation(id);
//        int participation = evaluationForm.getParticipation();
//        int techSkills = evaluationForm.getTechSkills();
//        int learningPace = evaluationForm.getLearningPace();
//        int extraMile = evaluationForm.getExtraMile();
//        String comment = evaluationForm.getComment();
//        long studentId = evaluationForm.getStudent().getId();
//        long mentorId = evaluationForm.getMentor().getId();
//        EvaluationDTO evaluationFormDTO = new EvaluationDTO(id, mentorId, participation, techSkills, learningPace, extraMile, comment, studentId);
//        return new ResponseEntity<EvaluationDTO>(evaluationFormDTO, HttpStatus.OK);
//    }

    @PostMapping(consumes = "application/json",produces = "application/json")
    public ResponseEntity<?>createEvaluation(@RequestBody EvaluationDTO evaluationFormDTO) throws StudentNotFoundException {
        Mentor mentor = mentorService.getMentor(evaluationFormDTO.getMentorID());
        Student student = studentService.getStudentByID(evaluationFormDTO.getStudentId());
        evaluationService.createEvaluation(evaluationFormDTO, mentor, student);
        return ResponseEntity.ok().build();
        }


//    @GetMapping(produces = "application/json")
//    public ResponseEntity<Void>getEvaluation(@RequestBody Evaluation evaluationForm) {
//        this.evaluationService.createEvaluation(evaluationForm);
//        return ResponseEntity.ok().build();
//    }
}
