package com.swedbank.academy.evaluationplatform.mentor;

import com.swedbank.academy.evaluationplatform.evaluationForm.EvaluationForm;
import com.swedbank.academy.evaluationplatform.evaluationForm.EvaluationFormDTO;
import com.swedbank.academy.evaluationplatform.evaluationForm.EvaluationFormService;
import com.swedbank.academy.evaluationplatform.mentor.exceptions.MentorNotFoundException;
import com.swedbank.academy.evaluationplatform.studentMentor.StudentMentor;
import com.swedbank.academy.evaluationplatform.studentMentor.StudentMentorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("api/mentor")
public class MentorController {

    private MentorService mentorService;
    private StudentMentorService studentMentorService;
    private EvaluationFormService evaluationFormService;

    public MentorController(MentorService mentorService, StudentMentorService studentMentorService, EvaluationFormService evaluationFormService) {

        this.mentorService = mentorService;
        this.studentMentorService = studentMentorService;
        this.evaluationFormService = evaluationFormService;
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<Set<MentorDTO>> getMentors(){
        Set<MentorDTO> mentors = mentorService.getMentors();
        return new ResponseEntity<>(mentors, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<MentorDTO> getMentors(@PathVariable long id){
        try {
            MentorDTO mentor = mentorService.getMentorById(id);
            return new ResponseEntity<>(mentor, HttpStatus.OK);
        } catch (MentorNotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("{id}/student")
    public ResponseEntity<Set<MentorStudentDTO>> getStudents(@PathVariable long id, @RequestParam(required = false) Integer isEvaluated){
        return new ResponseEntity<>(mentorService.getMentorsStudents(id, isEvaluated), HttpStatus.OK);
    }

    @GetMapping("{mentorId}/student/{studentMentorID}/evaluationForm/{formId}")
    public ResponseEntity<EvaluationForm> getEvaluationForms(@PathVariable long mentorId, @PathVariable long studentMentorID, @PathVariable long formId){
        EvaluationForm evaluationForm = evaluationFormService.getEvaluationForm(formId);
        return new ResponseEntity<EvaluationForm>(evaluationForm, HttpStatus.OK);
    }

    @GetMapping("{mentorId}/student/{studentId}/evaluation")
    public ResponseEntity<EvaluationFormDTO> getEvaluationForms(@PathVariable long mentorId, @PathVariable long studentId){
        EvaluationFormDTO evaluation = evaluationFormService.getEvaluationFormByIds(mentorId, studentId);
        return new ResponseEntity<EvaluationFormDTO>(evaluation, HttpStatus.OK);
    }

    @PostMapping("{mentorId}/student/{studentId}/evaluationForm")
        public ResponseEntity<Void>createEvaluationForm(@RequestBody EvaluationForm evaluationForm, @PathVariable long mentorId, @PathVariable long studentId){
        StudentMentor studentMentor = studentMentorService.getStudentMentorByIds(mentorId, studentId);
        evaluationFormService.createEvaluationForm(evaluationForm);
        studentMentorService.updateWhenEvaluationFormWasCreated(studentMentor.getId());
        return ResponseEntity.ok().build();
    }

    @PostMapping(consumes = "application/json")
    public ResponseEntity<Void> addMentor(@RequestBody Mentor mentor){
        mentorService.addMentor(mentor);
        return ResponseEntity.ok().build();
    }
}
