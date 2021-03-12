package com.swedbank.academy.evaluationplatform.lecturer;

import java.util.List;

public interface LecturerService {

    public List<Lecturer> getLecturers();

    void addLecturer(Lecturer lecturer);
}
