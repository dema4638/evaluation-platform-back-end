package com.swedbank.academy.evaluationplatform.student;
import com.swedbank.academy.evaluationplatform.evaluation.Evaluation;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
@Data
public class Student {

    @Id
    @SequenceGenerator(name = "student_sequence", sequenceName = "student_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_sequence")
    @Column(updatable = false)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "image")
    private String image;

    public Student() {
    }

    @OneToMany(mappedBy = "student")
    Set<Evaluation> evaluationForms;
}
