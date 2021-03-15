package com.swedbank.academy.evaluationplatform.mentor;

import com.swedbank.academy.evaluationplatform.evaluationForm.EvaluationForm;
import com.swedbank.academy.evaluationplatform.evaluationForm.EvaluationFormService;
import com.swedbank.academy.evaluationplatform.student.Student;
import com.swedbank.academy.evaluationplatform.studentMentor.StudentMentor;
import com.swedbank.academy.evaluationplatform.studentMentor.StudentMentorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("api/mentor")
public class MentorController {

    private MentorService mentorService;
    private StudentMentorService studentMentorService;
    private EvaluationFormService evaluationFormService;

    public MentorController(MentorService mentorService, StudentMentorService studentMentorService) {

        this.mentorService = mentorService;
        this.studentMentorService = studentMentorService;
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<Mentor>> getMentors(){
        List<Mentor> mentors = mentorService.getMentors();
        return new ResponseEntity<List<Mentor>>(mentors, HttpStatus.OK);
    }

    @GetMapping("{id}/student/{isEvaluated}")
    public ResponseEntity<Set<StudentMentor>> getStudents(@PathVariable long id, @RequestParam(required = false) Integer isEvaluated){
        Set<StudentMentor> mentorsStudents;
        Mentor mentor = mentorService.getMentor(id);
        if (isEvaluated == null) {
            mentorsStudents = mentor.getStudentsMentors();
        }else{
            mentorsStudents = mentor.getStudentsMentors(isEvaluated);
        }
        return new ResponseEntity<Set<StudentMentor>>(mentorsStudents, HttpStatus.OK);
    }

    @GetMapping("{mentorId}/student/{studentMentorID}/evaluationForm/{formId}")
    public ResponseEntity<EvaluationForm> getEvaluationForms(@PathVariable long mentorId, @PathVariable long studentMentorID, @PathVariable long formId){
        EvaluationForm evaluationForm = evaluationFormService.getEvaluationForm(formId);
        return new ResponseEntity<EvaluationForm>(evaluationForm, HttpStatus.OK);
    }

    @PostMapping("{mentorId}/student/{studentMentorID}/evaluationForm/{formId}")
        public ResponseEntity<Void>createEvaluationForm(@PathVariable long formId, @RequestBody EvaluationForm evaluationForm, @PathVariable long mentorId, @PathVariable long studentMentorID){
        evaluationFormService.createEvaluationForm(evaluationForm);
        studentMentorService.updateWhenEvaluationFormWasCreated(evaluationForm.getStudentMentor().getId());
        return ResponseEntity.ok().build();
    }

    @PostMapping(consumes = "application/json")
    public ResponseEntity<Void> addMentor(@RequestBody Mentor mentor){
        mentorService.addMentor(mentor);
        return ResponseEntity.ok().build();
    }
}
