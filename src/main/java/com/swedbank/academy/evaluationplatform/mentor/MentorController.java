package com.swedbank.academy.evaluationplatform.mentor;

import com.swedbank.academy.evaluationplatform.evaluation.EvaluationDTO;
import com.swedbank.academy.evaluationplatform.evaluation.EvaluationService;
import com.swedbank.academy.evaluationplatform.mentor.exceptions.MentorNotFoundException;
import com.swedbank.academy.evaluationplatform.student.Student;
import com.swedbank.academy.evaluationplatform.student.StudentDTO;
import com.swedbank.academy.evaluationplatform.student.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin(origins ="*", allowedHeaders ="*")
@RequestMapping("api/mentor")
public class MentorController {

    private MentorService mentorService;
    private EvaluationService evaluationService;
    private StudentService studentService;

    public MentorController(MentorService mentorService, EvaluationService evaluationService, StudentService studentService) {

        this.mentorService = mentorService;
        this.evaluationService = evaluationService;
        this.studentService = studentService;
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

    @GetMapping("{mentorId}/student/{studentId}/evaluation")
    public ResponseEntity<EvaluationDTO> getEvaluationForms(@PathVariable long mentorId, @PathVariable long studentId){
        EvaluationDTO evaluation = evaluationService.getEvaluationByIds(mentorId, studentId);
        return new ResponseEntity<EvaluationDTO>(evaluation, HttpStatus.OK);
    }

    @GetMapping("{mentorId}/student")
    public ResponseEntity<List<StudentDTO>> getStudents(@PathVariable long mentorId, @RequestParam(required = false) Integer isEvaluated){
        List<StudentDTO> students;
        if (isEvaluated == null){
            students = studentService.getAllStudents();
        }
        else if (isEvaluated == 1){
            System.out.println("Yes");
            students = studentService.getEvaluatedStudents(mentorId);

        }else {
            students = studentService.getNotEvaluatedStudents(mentorId);
        }

        return new ResponseEntity<List<StudentDTO>>(students, HttpStatus.OK);
    }

}
