package com.swedbank.academy.evaluationplatform.student;

import com.swedbank.academy.evaluationplatform.evaluation.EvaluationDTO;
import com.swedbank.academy.evaluationplatform.evaluation.EvaluationService;
import com.swedbank.academy.evaluationplatform.evaluation.JointEvaluationDTO;
import com.swedbank.academy.evaluationplatform.mentor.Mentor;
import com.swedbank.academy.evaluationplatform.mentor.MentorDTO;
import com.swedbank.academy.evaluationplatform.student.exception.StudentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;

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

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<StudentDTO>> getAllStudents(){
        List<StudentDTO> studentDTO = studentService.getAllStudents();
        return new ResponseEntity<>(studentDTO, HttpStatus.OK);
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

    @PostMapping(consumes = "application/json", produces = "application/json")
    @CrossOrigin(origins = "*", allowedHeaders = "*", methods = RequestMethod.POST)
    public ResponseEntity<Student> addStudent(@RequestBody @Valid StudentDTO studentDTO) {
           Student student = this.studentService.addStudent(studentDTO);
            return new ResponseEntity<Student>(student, HttpStatus.OK);
        }

    @PutMapping("{id}")
    @CrossOrigin(origins = "*", allowedHeaders = "*", methods = RequestMethod.PUT)
    public ResponseEntity<?> updateStudent(@RequestBody StudentDTO studentDTO, @PathVariable long id) {
        studentService.updateStudent(studentDTO, id);
        return new ResponseEntity<>(studentDTO, HttpStatus.OK);
    }

    }

