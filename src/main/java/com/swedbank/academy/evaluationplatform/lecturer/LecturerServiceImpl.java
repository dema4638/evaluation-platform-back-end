package com.swedbank.academy.evaluationplatform.lecturer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LecturerServiceImpl implements LecturerService {

    private LecturerRepository lecturerRepository;

    @Autowired
    public LecturerServiceImpl(LecturerRepository lecturerRepository) {
        this.lecturerRepository = lecturerRepository;
    }

    @Override
    public List<Lecturer> getLecturers() {
        return lecturerRepository.findAll();
    }

    @Override
    public void addLecturer(Lecturer lecturer) {
        this.lecturerRepository.save(lecturer);
    }
}
