package com.swedbank.academy.evaluationplatform.mentor;

import com.swedbank.academy.evaluationplatform.studentMentor.StudentMentor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
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
    Set<StudentMentor> studentsMentors;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Stream getStream() {
        return stream;
    }

    public Set<StudentMentor> StudentsMentors() {
        return studentsMentors;
    }

    public Set<StudentMentor> getStudentsMentors(Integer isEvaluated){
        Set<StudentMentor> evaluatedStudentsMentors = new HashSet<StudentMentor>();
        for (StudentMentor student : studentsMentors){
            if (student.isEvaluated()== isEvaluated){
                evaluatedStudentsMentors.add(student);
            }
        }
        return evaluatedStudentsMentors;
    }

    public Set<StudentMentor> getStudentsMentors() {
        return studentsMentors;
    }

}