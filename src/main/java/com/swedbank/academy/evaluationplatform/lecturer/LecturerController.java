package com.swedbank.academy.evaluationplatform.lecturer;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/lecturer")
public class LecturerController {

    private LecturerService lecturerService;

    public LecturerController(LecturerService lecturerService) {
        this.lecturerService = lecturerService;
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<Lecturer>> getLecturers(){
        List<Lecturer> lecturers = lecturerService.getLecturers();
        return new ResponseEntity<List<Lecturer>>(lecturers, HttpStatus.OK);
    }

    @PostMapping(consumes = "application/json")
    public ResponseEntity<Void> addLecturer(@RequestBody Lecturer lecturer){
        lecturerService.addLecturer(lecturer);
        return ResponseEntity.ok().build();
    }
}
