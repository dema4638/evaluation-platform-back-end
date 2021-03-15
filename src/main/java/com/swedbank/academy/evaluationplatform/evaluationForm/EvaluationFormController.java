package com.swedbank.academy.evaluationplatform.evaluationForm;

import com.swedbank.academy.evaluationplatform.studentMentor.StudentMentor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/mentor/{mentorId}/student/{studentId}/evaluationForm")
public class EvaluationFormController {

    EvaluationFormService evaluationFormService;

    public EvaluationFormController(EvaluationFormService evaluationFormService) {
        this.evaluationFormService = evaluationFormService;
    }

    @GetMapping("{id}")
    public ResponseEntity<EvaluationForm>getEvaluationForm(@PathVariable long id){
        EvaluationForm evaluationForm = this.evaluationFormService.getEvaluationForm(id);
        return new ResponseEntity<EvaluationForm>(evaluationForm, HttpStatus.OK);
    }

    @PostMapping(consumes = "application/json",produces = "application/json")
    public ResponseEntity<EvaluationForm>createEvaluationForm(@PathVariable long id){
        EvaluationForm evaluationForm = this.evaluationFormService.getEvaluationForm(id);

        return new ResponseEntity<EvaluationForm>(evaluationForm, HttpStatus.OK);
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<Void>getEvaluationForm(@RequestBody EvaluationForm evaluationForm) {
        this.evaluationFormService.createEvaluationForm(evaluationForm);
        return ResponseEntity.ok().build();
    }
}
