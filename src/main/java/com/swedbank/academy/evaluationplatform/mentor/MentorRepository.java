package com.swedbank.academy.evaluationplatform.mentor;

import com.swedbank.academy.evaluationplatform.evaluation.Evaluation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface MentorRepository extends JpaRepository<Mentor, Long> {
    @Transactional
    @Modifying
    @Query("DELETE FROM Evaluation evaluation WHERE evaluation.mentor.id = ?1")
    void deleteMentorsEvaluations(long mentorId);
}
