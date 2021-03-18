package com.swedbank.academy.evaluationplatform.mentor;

import com.swedbank.academy.evaluationplatform.evaluation.Evaluation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Mentor {

    @Id
    @SequenceGenerator(name = "mentor_sequence", sequenceName = "mentor_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mentor_sequence")
    private long id;
    @Column(name = "name")
    @NotNull private String name;
    @Column(name = "stream")
    private Stream stream;

    @OneToMany(mappedBy = "mentor")
    Set<Evaluation> evaluationForms;

//    public Set<StudentMentor> StudentsMentors() {
//        return studentsMentors;
//    }

//    public Set<StudentMentor> getStudentsMentors(Integer isEvaluated){
//        Set<StudentMentor> evaluatedStudentsMentors = new HashSet<StudentMentor>();
//        for (StudentMentor student : studentsMentors){
//            if (student.isEvaluated().equals(isEvaluated)){
//                evaluatedStudentsMentors.add(student);
//            }
//        }
//        return evaluatedStudentsMentors;
//    }
//
//    public Set<StudentMentor> getStudentsMentors() {
//        return studentsMentors;
//    }

}