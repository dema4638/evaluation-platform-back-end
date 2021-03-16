package com.swedbank.academy.evaluationplatform.mentor;

import com.swedbank.academy.evaluationplatform.studentMentor.StudentMentor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Set;

public interface MentorService {

    public Set<MentorDTO> getMentors();

    public MentorDTO getMentorById(long id);

    public Set<MentorStudentDTO> getMentorsStudents(long id, Integer isEvaluated);

    public Mentor getMentor(long id);

    public ResponseEntity<List<StudentMentor>> getMentorsStudents(@PathVariable long id);

    void addMentor(Mentor mentor);
}
