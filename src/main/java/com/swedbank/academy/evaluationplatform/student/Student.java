package com.swedbank.academy.evaluationplatform.student;
import com.swedbank.academy.evaluationplatform.evaluation.Evaluation;
import com.swedbank.academy.evaluationplatform.student.preference.Preference;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table
@Data
public class Student {

    @Id
    @SequenceGenerator(name = "student_sequence", sequenceName = "student_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_sequence")
    @Column(updatable = false)
    @NotNull
    private long id;

    @Column(name = "name")
    @NotNull
    private String name;

    @Column(name = "image")
    @NotNull
    private String image;

    @Column(name = "contractType")
    private String contractType;

    public Student() {
    }

    @OneToMany(mappedBy = "student")
    Set<Evaluation> evaluationForms;

    @ManyToMany
    @JoinTable(
            name = "student_preference",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "preference_id"))
    Set<Preference> preferences;

    public Student(@NotNull String name, @NotNull String image, String contractType, Set<Preference> preferences) {
        this.name = name;
        this.image = image;
        this.contractType = contractType;
        this.preferences = preferences;
    }

    public Student(@NotNull String name, @NotNull String image, String contractType) {
        this.name = name;
        this.image = image;
        this.contractType = contractType;
    }

    public Student(@NotNull Long id,@NotNull String name, @NotNull String image, String contractType, Set<Preference> preferences) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.contractType = contractType;
        this.preferences = preferences;
    }

    public List<String> getPreferencesString(){
        List<String> preferencesList = new ArrayList<>();
        for (Preference preference: preferences){
            preferencesList.add(preference.getPreference());
            System.out.println(preference.getPreference());
        }
        return preferencesList;
    }
}
