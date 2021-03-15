package com.swedbank.academy.evaluationplatform.mentor;

import com.swedbank.academy.evaluationplatform.studentMentor.StudentMentor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MentorServiceImpl implements MentorService {

    private MentorRepository mentorRepository;

    @Autowired
    public MentorServiceImpl(MentorRepository mentorRepository) {
        this.mentorRepository = mentorRepository;
    }

    @Override
    public List<Mentor> getMentors() {
        return mentorRepository.findAll();
    }

    @Override
    public Mentor getMentor(long id) {
        return mentorRepository.findById(id).get();
    }

    @Override
    public ResponseEntity<List<StudentMentor>> getMentorsStudents(long id) {
        return null;
    }

    @Override
    public void addMentor(Mentor mentor) {
        this.mentorRepository.save(mentor);
    }
}
