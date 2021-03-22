package com.swedbank.academy.evaluationplatform.evaluation;

import com.swedbank.academy.evaluationplatform.mentor.Mentor;
import com.swedbank.academy.evaluationplatform.mentor.Stream;
import com.swedbank.academy.evaluationplatform.student.Student;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table
@Data
@NoArgsConstructor
@Getter
public class Evaluation {


    public Evaluation(int participation, int techSkills, int learningPace, int extraMile, String comment, Mentor mentor, Student student, Stream stream) {
        this.participation = participation;
        this.techSkills = techSkills;
        this.learningPace = learningPace;
        this.extraMile = extraMile;
        this.comment = comment;
        this.mentor = mentor;
        this.student = student;
        this.stream = stream;
    }

    @Id
    @SequenceGenerator(name = "evaluationForm_sequence", sequenceName = "evaluationForm_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "evaluationForm_sequence")
    @NotNull
    private long id;

    @ManyToOne
    @JoinColumn(name = "mentor_id")
    @NotNull
    private Mentor mentor;

    @ManyToOne
    @JoinColumn(name = "student_id")
    @NotNull
    private Student student;

    @Column(name = "participation")
    @NotNull
    private int participation;

    @Column(name = "tech_skills")
    @NotNull
    private int techSkills;


    @Column(name = "learning_pace")
    @NotNull
    private int learningPace;

    @Column(name = "extra_mile")
    @NotNull
    private int extraMile;

    @Column(name = "comment")
    @NotNull
    @Size(min = 0, max = 200)
    private String comment;

    @Column(name = "stream")
    @NotNull
    private Stream stream;


    public long getId() {
        return id;
    }

    public int getParticipation() {
        return participation;
    }

    public int getLearningPace() {
        return learningPace;
    }

    public int getExtraMile() {
        return extraMile;
    }

    public String getComment() {
        return comment;
    }

    public int getTechSkills() {
        return techSkills;
    }


}
