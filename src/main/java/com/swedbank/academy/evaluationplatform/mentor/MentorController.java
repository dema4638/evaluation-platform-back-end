package com.swedbank.academy.evaluationplatform.mentor;

import com.swedbank.academy.evaluationplatform.mentor.exceptions.MentorNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/mentor")
public class MentorController {

    private MentorService mentorService;

    public MentorController(MentorService mentorService) {
        this.mentorService = mentorService;
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<Mentor>> getMentors(){
        List<Mentor> mentors = mentorService.getMentors();
        return new ResponseEntity<List<Mentor>>(mentors, HttpStatus.OK);
    }

    @PostMapping(consumes = "application/json")
    public ResponseEntity<Void> addMentor(@RequestBody Mentor mentor){
        mentorService.addMentor(mentor);
        return ResponseEntity.ok().build();
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<Mentor> getMentorById(Mentor mentor){
        try {
            mentor = mentorService.getMentorById(mentor.getId());
            return new ResponseEntity<Mentor>(mentor, HttpStatus.OK);
        }
        catch (MentorNotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }

}
