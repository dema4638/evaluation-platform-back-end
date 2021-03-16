package com.swedbank.academy.evaluationplatform.mentor;

import com.swedbank.academy.evaluationplatform.student.Student;
import com.swedbank.academy.evaluationplatform.studentMentor.StudentMentor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
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
    public MentorDTO getMentorById(long id) {
        Mentor mentor = mentorRepository.findById(id).get();
        MentorDTO mentorDTO = new MentorDTO(mentor.getId(), mentor.getName(), mentor.getStream());
        return mentorDTO;
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

    @Override
    public Set<MentorStudentDTO> getMentorsStudents(long id, Integer isEvaluated){
        Set<StudentMentor> mentorsStudents;
        Set<MentorStudentDTO>mentorStudentDTOs = new HashSet<>();
        Mentor mentor = getMentor(id);
        if (isEvaluated == null) {
            mentorsStudents = mentor.getStudentsMentors();
        }else{
            mentorsStudents = mentor.getStudentsMentors(isEvaluated);
        }
        for(StudentMentor studentMentor : mentorsStudents){
            Student student = studentMentor.getStudent();
            String image = student.getImage();
            String name = student.getName();
            long studentId = student.getId();
            Integer isStudentEvaluated = studentMentor.isEvaluated();
            boolean isStudentEvaluatedBool;
            if (isStudentEvaluated==1){
                isStudentEvaluatedBool=true;
            }else{
                isStudentEvaluatedBool=false;
            }

            mentorStudentDTOs.add(new MentorStudentDTO(studentId, name, image, isStudentEvaluatedBool));
        }
        return mentorStudentDTOs;
    }


}
