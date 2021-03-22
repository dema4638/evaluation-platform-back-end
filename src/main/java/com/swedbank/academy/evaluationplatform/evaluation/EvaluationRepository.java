package com.swedbank.academy.evaluationplatform.evaluation;

import com.swedbank.academy.evaluationplatform.mentor.Stream;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EvaluationRepository extends JpaRepository<Evaluation, Long> {

    @Query("SELECT evaluation FROM Evaluation evaluation WHERE evaluation.stream = ?1 AND evaluation.student.id=?2")
    List<Evaluation> getEvaluationsByStream(Stream streamValue, long studentId);

    @Query("SELECT AVG(evaluation.participation) FROM Evaluation evaluation WHERE evaluation.stream = ?1 AND evaluation.student.id=?2")
    Double getAvgParticipationByStream(Stream streamValue, long studentId);

    @Query("SELECT AVG(evaluation.techSkills) FROM Evaluation evaluation WHERE evaluation.stream = ?1 AND evaluation.student.id=?2")
    Double getAvgTechSkillsByStream(Stream streamValue, long studentId);

    @Query("SELECT AVG(evaluation.learningPace) FROM Evaluation evaluation WHERE evaluation.stream = ?1 AND evaluation.student.id=?2")
    Double getAvgLearningPaceByStream(Stream streamValue, long studentId);

    @Query("SELECT AVG(evaluation.extraMile) FROM Evaluation evaluation WHERE evaluation.stream = ?1 AND evaluation.student.id=?2")
    Double getAvgExtraMileByStream(Stream streamValue, long studentId);

    @Query("SELECT evaluation.comment FROM Evaluation evaluation WHERE evaluation.stream = ?1 AND evaluation.student.id=?2")
    List<String> getEvaluationCommentsByStream(Stream streamValue, long studentId);

    @Query("SELECT COUNT(evaluation) FROM Evaluation evaluation WHERE evaluation.stream = ?1 AND evaluation.student.id=?2")
    Double getEvaluationsCountByStream(Stream streamValue, long studentId);
}
