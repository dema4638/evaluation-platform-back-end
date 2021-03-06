package com.swedbank.academy.evaluationplatform.mentor;

import com.swedbank.academy.evaluationplatform.mentor.exceptions.MentorNotFoundException;

import java.util.ArrayList;
import java.util.Set;

public interface MentorService {

    public Set<MentorDTO> getMentors();

    public MentorDTO getMentorById(long id)  throws MentorNotFoundException;

    public Mentor getMentor(long id) throws MentorNotFoundException;

    Mentor addMentor(MentorDTO mentorDTO);

    void deleteMentor(long mentorId);
}
