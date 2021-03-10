package com.swedbank.academy.evaluationplatform.teacher;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/teacher")
public class TeacherController {

    private TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<Teacher>> getTeachers(){
        List<Teacher> teachers = teacherService.getTeachers();
        return new ResponseEntity<List<Teacher>>(teachers, HttpStatus.OK);
    }

    @PostMapping(consumes = "application/json")
    public ResponseEntity<Void> addTeacher(@RequestBody Teacher teacher){
        teacherService.addTeacher(teacher);
        return ResponseEntity.ok().build();
    }
}
