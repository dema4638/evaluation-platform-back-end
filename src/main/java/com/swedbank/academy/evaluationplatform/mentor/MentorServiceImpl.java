package com.swedbank.academy.evaluationplatform.mentor;

import com.swedbank.academy.evaluationplatform.mentor.exceptions.MentorNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

@Service
public class MentorServiceImpl implements MentorService {

    private MentorRepository mentorRepository;

    @Autowired
    public MentorServiceImpl(MentorRepository mentorRepository) {
        this.mentorRepository = mentorRepository;
    }

    @Override
    public Set<MentorDTO> getMentors() {

        List<Mentor>mentors =  mentorRepository.findAll();
        Set<MentorDTO> mentorsDto = new HashSet<>();
        for (Mentor mentor : mentors){
            mentorsDto.add(new MentorDTO(mentor.getId(), mentor.getName(), mentor.getStream()));
        }
        return mentorsDto;
    }

    @Override
    public MentorDTO getMentorById(long id) throws MentorNotFoundException {
        Mentor mentor;
        try {
            mentor = mentorRepository.findById(id).get();
            MentorDTO mentorDTO = new MentorDTO(mentor.getId(), mentor.getName(), mentor.getStream());
            return mentorDTO;
        } catch (NoSuchElementException e){
            throw new MentorNotFoundException("Mentor with given ID does not exist");
        }

    }

    @Override
    public Mentor getMentor(long id) throws MentorNotFoundException {
        try {
            return mentorRepository.findById(id).get();
        } catch (NoSuchElementException e) {
            throw new MentorNotFoundException("Mentor with given ID does not exist");
        }
    }

    @Override
    public void addMentor(Mentor mentor) {
        this.mentorRepository.save(mentor);
    }

    @Override
    public void deleteMentor(Mentor mentor) {
        this.mentorRepository.delete(mentor);
    }
}
