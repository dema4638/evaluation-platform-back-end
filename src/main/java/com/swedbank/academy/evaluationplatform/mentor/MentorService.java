package com.swedbank.academy.evaluationplatform.mentor;

import com.swedbank.academy.evaluationplatform.studentMentor.StudentMentor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface MentorService {

    public List<Mentor> getMentors();

    public Mentor getMentor(long id);

    public ResponseEntity<List<StudentMentor>> getMentorsStudents(@PathVariable long id);

    void addMentor(Mentor mentor);
}
