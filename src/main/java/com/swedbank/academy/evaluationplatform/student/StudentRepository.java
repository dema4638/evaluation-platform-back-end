package com.swedbank.academy.evaluationplatform.student;

import com.swedbank.academy.evaluationplatform.student.preference.Preference;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query("SELECT preference FROM Preference preference WHERE preference.preference = ?1")
    Preference getPreference(String preference);

    @Transactional
    @Modifying
    @Query(value="insert into student_preference (student_id, preference_id) values (?1, ?2);", nativeQuery=true)
    void addPreference(long studentId, long preference_id);


}
