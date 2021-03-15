package com.swedbank.academy.evaluationplatform.mentor;

import com.swedbank.academy.evaluationplatform.mentor.exceptions.MentorNotFoundException;

import java.util.List;

public interface MentorService {

    public List<Mentor> getMentors();

    void addMentor(Mentor mentor);

    Mentor getMentorById (long id) throws MentorNotFoundException;
}
