package com.swedbank.academy.evaluationplatform.student;

import com.swedbank.academy.evaluationplatform.evaluation.EvaluationService;
import com.swedbank.academy.evaluationplatform.mentor.Mentor;
import com.swedbank.academy.evaluationplatform.student.exception.StudentNotFoundException;
import com.swedbank.academy.evaluationplatform.student.preference.Preference;
import org.springframework.stereotype.Service;

import javax.validation.Valid;

import java.util.*;


@Service
public class StudentServiceImpl implements StudentService {
    private StudentRepository studentRepository;
    private EvaluationService evaluationService;


    public StudentServiceImpl(StudentRepository studentRepository, EvaluationService evaluationService) {
        this.studentRepository = studentRepository;
        this.evaluationService = evaluationService;
    }

    @Override
    public StudentDTO getStudentByID(long id) throws StudentNotFoundException {
        System.out.println("Hello");
        Student student;
        try {
            student = studentRepository.findById(id).get();
            return new StudentDTO(student.getId(), student.getName(), student.getImage(), student.getContractType(), student.getPreferencesString());
        } catch (NoSuchElementException e) {
            throw new StudentNotFoundException("Student with given ID does not exist");
        }
    }

    @Override
    public Student getStudent(long id) throws StudentNotFoundException {
        Student student;
        try {
            student = studentRepository.findById(id).get();
            return student;
        } catch (NoSuchElementException e) {
            throw new StudentNotFoundException("Student with given ID does not exist");
        }
    }

    public List<StudentDTO> getAllStudents(Mentor mentor){
        List<Student> students = studentRepository.findAll();
        List<StudentDTO> studentsDTO = new ArrayList<>();
        for (Student student: students){
            studentsDTO.add(getStudentDTO(student, mentor));
        }
        return studentsDTO;
    }

    @Override
    public List<StudentDTO> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        List<StudentDTO> studentsDTO = new ArrayList<>();
        for (Student student: students){
            String name = student.getName();
            String image = student.getImage();
            long id = student.getId();
            String contract = student.getContractType();
            List<String> preferences = student.getPreferencesString();
            studentsDTO.add(new StudentDTO(id, name, image, contract, preferences));
        }
        return studentsDTO;
    }


    @Override
    public StudentDTO getStudentDTO(@Valid Student student, Mentor mentor) {
        String name = student.getName();
        String image = student.getImage();
        long id = student.getId();
        String contract = student.getContractType();
        List<String> preferences = student.getPreferencesString();
            if (evaluationService.checkIfEvaluationExists(mentor.getId(),student.getId())){
                return new StudentDTO(id, name, image, true, contract, preferences);
            }
        return new StudentDTO(id, name, image, false, contract, preferences);
    }
    @Override
    public void deleteStudent(long studentId){
        studentRepository.deleteStudentEvaluations(studentId);
        studentRepository.deleteById(studentId);
    }

    public Student addStudent(StudentDTO studentDTO) {
         Set<Preference> preferences = getPreferences(studentDTO);
         Student student = new Student(studentDTO.getName(), studentDTO.getImage(), studentDTO.getContractType(), preferences);
         studentRepository.save(student);
         return student;
    }

    @Override
    public void updateStudent(StudentDTO studentDTO, long studentId){
        Set<Preference> preferences = getPreferences(studentDTO);
        studentRepository.save(new Student(studentId, studentDTO.getName(), studentDTO.getImage(), studentDTO.getContractType(), preferences));
    }

    private Set<Preference> getPreferences(StudentDTO studentDTO){
        List<String> studentPreferences = studentDTO.getPreferences();
        Set<Preference> preferences = new HashSet<>();
        for (String preference: studentPreferences){
            Preference preferenceFromTable = studentRepository.getPreference(preference);
            preferences.add(preferenceFromTable);
        }
        return preferences;
    }
}
