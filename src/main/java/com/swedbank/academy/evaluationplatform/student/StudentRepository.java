package com.swedbank.academy.evaluationplatform.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface StudentRepository extends JpaRepository<Student, Long> {

    @Transactional
    @Modifying
    @Query("DELETE FROM Evaluation evaluation WHERE evaluation.student.id = ?1")
    void deleteStudentEvaluations(long studentId);

}
