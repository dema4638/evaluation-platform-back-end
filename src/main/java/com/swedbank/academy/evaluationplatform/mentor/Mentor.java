package com.swedbank.academy.evaluationplatform.mentor;

import com.swedbank.academy.evaluationplatform.evaluation.Evaluation;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Table
@Data
public class Mentor {

    @Id
    @SequenceGenerator(name = "mentor_sequence", sequenceName = "mentor_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mentor_sequence")
    @NotNull
    private long id;
    @Column(name = "name")
    @NotNull
    private String name;
    @Column(name = "stream")
    @NotNull
    private Stream stream;

    public Mentor() {
    }

    public Mentor(@NotNull long id, @NotNull String name, @NotNull Stream stream, Set<Evaluation> evaluationForms) {
        this.id = id;
        this.name = name;
        this.stream = stream;
        this.evaluationForms = evaluationForms;
    }

    public Mentor(@NotNull String name, @NotNull Stream stream) {
        this.name = name;
        this.stream = stream;
    }


    @OneToMany(mappedBy = "mentor")
    Set<Evaluation> evaluationForms;


}