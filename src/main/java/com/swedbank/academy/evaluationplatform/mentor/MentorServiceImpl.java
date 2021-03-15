package com.swedbank.academy.evaluationplatform.mentor;

import com.swedbank.academy.evaluationplatform.mentor.exceptions.MentorNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
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
    public void addMentor(Mentor mentor) {
        this.mentorRepository.save(mentor);
    }

    @Override
    public Mentor getMentorById(long id) throws MentorNotFoundException {
        for (Mentor a : getMentors()){
            if (id == a.getId()){
                return a;
            }
        }
        throw new MentorNotFoundException("Mentor with given ID does not exist");
    }
}
