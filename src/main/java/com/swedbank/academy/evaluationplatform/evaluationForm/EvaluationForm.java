package com.swedbank.academy.evaluationplatform.evaluationForm;

import com.swedbank.academy.evaluationplatform.studentMentor.StudentMentor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table
@Data
@NoArgsConstructor
@Getter
public class EvaluationForm {

    public EvaluationForm(StudentMentor studentMentor, int participation, int techSkills, int learningPace, int extraMile, String comment) {
        this.studentMentor = studentMentor;
        this.participation = participation;
        this.techSkills = techSkills;
        this.learningPace = learningPace;
        this.extraMile = extraMile;
        this.comment = comment;
    }

    @Id
    @SequenceGenerator(name = "evaluationForm_sequence", sequenceName = "evaluationForm_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "evaluationForm_sequence")
    private long id;


    @OneToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "student_mentor_id", referencedColumnName = "id")
    private StudentMentor studentMentor;

    @Column(name = "participation")
    private int participation;

    @Column(name = "tech_skills")
    private int techSkills;


    @Column(name = "learning_pace")
    private int learningPace;

    @Column(name = "extra_mile")
    private int extraMile;

    @Column(name = "comment")
    private String comment;

    public long getId() {
        return id;
    }

    public StudentMentor getStudentMentor() {
        return studentMentor;
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
