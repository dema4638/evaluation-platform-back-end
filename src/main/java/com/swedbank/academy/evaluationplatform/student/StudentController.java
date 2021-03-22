package com.swedbank.academy.evaluationplatform.student;

import com.swedbank.academy.evaluationplatform.evaluation.EvaluationService;
import com.swedbank.academy.evaluationplatform.evaluation.JointEvaluationDTO;
import com.swedbank.academy.evaluationplatform.student.exception.StudentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins ="*", allowedHeaders ="*")
@RequestMapping("api/student")
public class StudentController {



    private StudentService studentService;
    private EvaluationService evaluationService;

    public StudentController(StudentService studentService, EvaluationService evaluationService) {
        this.studentService = studentService;
        this.evaluationService = evaluationService;
    }

    @GetMapping("{id}")
    public ResponseEntity<StudentDTO> getStudent(@PathVariable long id) {
        try {
            StudentDTO studentDTO = studentService.getStudentByID(id);
            return new ResponseEntity<>(studentDTO, HttpStatus.OK);
        } catch (StudentNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping(value = "{studentId}/jointEvaluation")
    public ResponseEntity<JointEvaluationDTO> getJointEvaluation(@PathVariable long studentId){
        JointEvaluationDTO jointEvaluation = evaluationService.getJointEvaluation(studentId);
        return new ResponseEntity<JointEvaluationDTO>(jointEvaluation,HttpStatus.OK);
    }
}
