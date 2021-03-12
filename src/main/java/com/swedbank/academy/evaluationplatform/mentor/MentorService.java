package com.swedbank.academy.evaluationplatform.mentor;

import java.util.List;

public interface MentorService {

    public List<Mentor> getMentors();

    void addMentor(Mentor mentor);
}
