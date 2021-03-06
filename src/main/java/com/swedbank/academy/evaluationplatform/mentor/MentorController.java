package com.swedbank.academy.evaluationplatform.mentor;

import com.swedbank.academy.evaluationplatform.evaluation.EvaluationDTO;
import com.swedbank.academy.evaluationplatform.evaluation.EvaluationService;
import com.swedbank.academy.evaluationplatform.evaluation.exceptions.EvaluationNotFoundException;
import com.swedbank.academy.evaluationplatform.mentor.exceptions.MentorNotFoundException;
import com.swedbank.academy.evaluationplatform.student.StudentDTO;
import com.swedbank.academy.evaluationplatform.student.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
        System.out.println("hello");
        try {;
            MentorDTO mentor = mentorService.getMentorById(id);
            return new ResponseEntity<>(mentor, HttpStatus.OK);
        } catch (MentorNotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("{mentorId}/student/{studentId}/evaluation")
    public ResponseEntity<EvaluationDTO> getEvaluationForms(@PathVariable long mentorId, @PathVariable long studentId){
        try {
            EvaluationDTO evaluation = evaluationService.getEvaluationByIds(mentorId, studentId);
            return new ResponseEntity<EvaluationDTO>(evaluation, HttpStatus.OK);
        } catch (EvaluationNotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("{mentorId}/student")
    public ResponseEntity<List<StudentDTO>> getStudents(@PathVariable long mentorId) {
        List<StudentDTO> students;
        Mentor mentor;
        try {
            mentor = mentorService.getMentor(mentorId);
            students = studentService.getAllStudents(mentor);
            return new ResponseEntity<>(students, HttpStatus.OK);
        } catch (MentorNotFoundException e) {
            e.printStackTrace();
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    @CrossOrigin(origins = "*", allowedHeaders = "*", methods = RequestMethod.POST)
    public ResponseEntity<Mentor> addMentor(@RequestBody @Valid MentorDTO mentorDTO) {
        Mentor mentor = mentorService.addMentor(mentorDTO);
        return new ResponseEntity<>(mentor, HttpStatus.OK);
    }

    @DeleteMapping("{mentorId}")
    public ResponseEntity<?> deleteMentors(@PathVariable @Valid long mentorId) {
        mentorService.deleteMentor(mentorId);
        return ResponseEntity.ok().build();
    }
}
