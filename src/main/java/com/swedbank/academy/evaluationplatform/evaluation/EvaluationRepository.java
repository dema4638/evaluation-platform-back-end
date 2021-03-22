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

    @Query("UPDATE Evaluation evaluation SET evaluation.comment=?1 , evaluation.extraMile=?2, evaluation.learningPace=?3, " +
            "evaluation.participation=?4, evaluation.stream=?5, evaluation.techSkills=?6 " +
            "WHERE evaluation.mentor.id=?7 AND evaluation.student.id=?8 ")
    void updateEvaluation (String comment, int extraMile, int learningPace, int participation, Stream stream,
                           int techSkills, long mentorID, long studentID);

}
