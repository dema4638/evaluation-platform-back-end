package com.swedbank.academy.evaluationplatform.mentor;

import com.swedbank.academy.evaluationplatform.evaluation.EvaluationDTO;
import com.swedbank.academy.evaluationplatform.evaluation.EvaluationService;
import com.swedbank.academy.evaluationplatform.mentor.exceptions.MentorNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("api/mentor")
public class MentorController {

    private MentorService mentorService;
    private EvaluationService evaluationService;

    public MentorController(MentorService mentorService, EvaluationService evaluationService) {

        this.mentorService = mentorService;
        this.evaluationService = evaluationService;
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<Set<MentorDTO>> getMentors(){
        Set<MentorDTO> mentors = mentorService.getMentors();
        return new ResponseEntity<>(mentors, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<MentorDTO> getMentor(@PathVariable long id){
        try {
            MentorDTO mentor = mentorService.getMentorById(id);
            return new ResponseEntity<>(mentor, HttpStatus.OK);
        } catch (MentorNotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping(consumes = "application/json")
    public ResponseEntity<Void> addMentor(@RequestBody Mentor mentor){
        mentorService.addMentor(mentor);
        return ResponseEntity.ok().build();
    }

    @GetMapping("{mentorId}/student/{studentId}/evaluation")
    public ResponseEntity<EvaluationDTO> getEvaluationForms(@PathVariable long mentorId, @PathVariable long studentId){
        EvaluationDTO evaluation = evaluationService.getEvaluationByIds(mentorId, studentId);
        return new ResponseEntity<EvaluationDTO>(evaluation, HttpStatus.OK);
    }

//    @GetMapping("{id}/student")
//    public ResponseEntity<Set<MentorStudentDTO>> getStudents(@PathVariable long id, @RequestParam(required = false) Integer isEvaluated){
//        return new ResponseEntity<>(mentorService.getMentorsStudents(id, isEvaluated), HttpStatus.OK);
//    }


//    @PostMapping("{mentorId}/student/{studentId}/evaluationForm")
//        public ResponseEntity<Void>createEvaluationForm(@RequestBody Evaluation evaluationForm, @PathVariable long mentorId, @PathVariable long studentId){
//        evaluationService.createEvaluation(evaluationForm);
//        return ResponseEntity.ok().build();
//    }

}
