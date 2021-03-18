package com.swedbank.academy.evaluationplatform.evaluationForm;

import com.swedbank.academy.evaluationplatform.mentor.Mentor;
import com.swedbank.academy.evaluationplatform.mentor.Stream;
import com.swedbank.academy.evaluationplatform.student.Student;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table
@Data
@NoArgsConstructor
@Getter
public class Evaluation {

    public Evaluation(int participation, int techSkills, int learningPace, int extraMile, String comment, Mentor mentor, Student student) {
        this.participation = participation;
        this.techSkills = techSkills;
        this.learningPace = learningPace;
        this.extraMile = extraMile;
        this.comment = comment;
        this.mentor = mentor;
        this.student = student;
    }

    @Id
    @SequenceGenerator(name = "evaluationForm_sequence", sequenceName = "evaluationForm_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "evaluationForm_sequence")
    private long id;

    @ManyToOne
    @JoinColumn(name = "mentor_id")
    private Mentor mentor;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

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

    @Column(name = "stream")
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
