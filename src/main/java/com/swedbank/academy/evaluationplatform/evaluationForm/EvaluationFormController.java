package com.swedbank.academy.evaluationplatform.evaluationForm;

import com.swedbank.academy.evaluationplatform.student.StudentDTO;
import com.swedbank.academy.evaluationplatform.studentMentor.StudentMentor;
import com.swedbank.academy.evaluationplatform.studentMentor.StudentMentorService;
import org.hibernate.engine.jdbc.spi.SqlExceptionHelper;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin(origins ="*", allowedHeaders ="*")
@RequestMapping("api/evaluation")
public class EvaluationFormController {

    EvaluationFormService evaluationFormService;
    StudentMentorService studentMentorService;

    public EvaluationFormController(EvaluationFormService evaluationFormService, StudentMentorService studentMentorService) {
        this.evaluationFormService = evaluationFormService;
        this.studentMentorService=studentMentorService;
    }

    @GetMapping("{id}")
    @CrossOrigin(origins ="*", allowedHeaders ="*")
    public ResponseEntity<EvaluationFormDTO>getEvaluationForm(@PathVariable long id){
        EvaluationForm evaluationForm = this.evaluationFormService.getEvaluationForm(id);
        long formId= evaluationForm.getId();
        int participation = evaluationForm.getParticipation();
        int techSkills = evaluationForm.getTechSkills();
        int learningPace = evaluationForm.getLearningPace();
        int extraMile = evaluationForm.getExtraMile();
        String comment = evaluationForm.getComment();
        long studentId = evaluationForm.getStudentMentor().getStudent().getId();
        long mentorId = evaluationForm.getStudentMentor().getMentor().getId();
        EvaluationFormDTO evaluationFormDTO = new EvaluationFormDTO(formId, mentorId, participation, techSkills, learningPace, extraMile, comment, studentId);
        return new ResponseEntity<EvaluationFormDTO>(evaluationFormDTO, HttpStatus.OK);
    }

    @PostMapping(consumes = "application/json",produces = "application/json")
    @CrossOrigin(origins ="*", allowedHeaders ="*", methods = RequestMethod.POST)
    public ResponseEntity<?>createEvaluationForm(@RequestBody EvaluationFormDTO evaluationFormDTO) {
        long mentorId = evaluationFormDTO.getMentorID();
        long studentId = evaluationFormDTO.getStudentId();
        String comment = evaluationFormDTO.getComment();
        int participation = evaluationFormDTO.getParticipation();
        int techSkills = evaluationFormDTO.getTechSkills();
        int learningPace = evaluationFormDTO.getLearningPace();
        int extraMile = evaluationFormDTO.getExtraMile();
        StudentMentor studentMentor = studentMentorService.getStudentMentorByIds(mentorId, studentId);
        if (studentMentor == null) {
            return new ResponseEntity<String>("Could not find student+mentor with provided IDs", HttpStatus.BAD_REQUEST);
        }
        EvaluationForm evaluationForm = new EvaluationForm(studentMentor, participation, techSkills, learningPace, extraMile, comment);
        evaluationFormService.createEvaluationForm(evaluationForm);
        studentMentorService.updateWhenEvaluationFormWasCreated(studentMentor.getId());
        return ResponseEntity.ok().build();
        }

//    @PostMapping(consumes = "application/json",produces = "application/json")
//    public ResponseEntity<EvaluationForm>createEvaluationForm(@PathVariable long id){
//        EvaluationForm evaluationForm = this.evaluationFormService.getEvaluationForm(id);
//
//        return new ResponseEntity<EvaluationForm>(evaluationForm, HttpStatus.OK);
//    }

    @GetMapping(produces = "application/json")
    @CrossOrigin(origins ="*", allowedHeaders ="*")
    public ResponseEntity<Void>getEvaluationForm(@RequestBody EvaluationForm evaluationForm) {
        this.evaluationFormService.createEvaluationForm(evaluationForm);
        return ResponseEntity.ok().build();
    }
}
