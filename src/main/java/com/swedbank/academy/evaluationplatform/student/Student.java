package com.swedbank.academy.evaluationplatform.student;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.swedbank.academy.evaluationplatform.studentMentor.StudentMentor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
@Getter
@Setter
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

//    @OneToMany(mappedBy = "student",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JsonIgnore
//    @ToString.Exclude
//    @EqualsAndHashCode.Exclude
//    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @OneToMany(mappedBy = "student")
    Set<StudentMentor> StudentsMentors;
}
