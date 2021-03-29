package com.swedbank.academy.evaluationplatform.student.preference;

import com.swedbank.academy.evaluationplatform.student.Student;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Table
public class Preference {
    @Id
    @SequenceGenerator(name = "preference_sequence", sequenceName = "preference_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "preference_sequence")
    @Column(updatable = false)
    @NotNull
    private long id;

    @Column(name = "preference")
    @NotNull
    private String preference;

    @ManyToMany(mappedBy = "preferences")
    Set<Student> students;

    public long getId() {
        return id;
    }

    public String getPreference() {
        return preference;
    }
}
