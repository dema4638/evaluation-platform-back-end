package com.swedbank.academy.evaluationplatform.studentMentor;

import com.swedbank.academy.evaluationplatform.evaluationForm.EvaluationForm;
import com.swedbank.academy.evaluationplatform.mentor.Mentor;
import com.swedbank.academy.evaluationplatform.student.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Table
@NoArgsConstructor
@Getter
public class StudentMentor {

    @Id
    @SequenceGenerator(name = "studentMentor_sequence", sequenceName = "studentMentor_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "studentMentor_sequence")
    private long id;

//    @ManyToOne(fetch = FetchType.LAZY)
    @ManyToOne
    @JoinColumn(name = "mentor_id")
    private Mentor mentor;

//    @ManyToOne(fetch = FetchType.LAZY)
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @Column(name = "is_evaluated")
    private Integer isEvaluated;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "evaluation_form_id", referencedColumnName = "id")
//    private EvaluationForm evaluationForm;

    @OneToOne(mappedBy = "studentMentor")
    private EvaluationForm evaluationForm;

    public StudentMentor(long id, Mentor mentor, Student student, Integer isEvaluated, EvaluationForm evaluationForm) {
        this.id = id;
        this.mentor = mentor;
        this.student = student;
        this.isEvaluated = isEvaluated;
        this.evaluationForm = evaluationForm;
    }

    public long getId() {
        return id;
    }

    public Mentor getMentor() {
        return mentor;
    }

    public Student getStudent() {
        return student;
    }

    public Integer isEvaluated() {
        return isEvaluated;
    }

}
