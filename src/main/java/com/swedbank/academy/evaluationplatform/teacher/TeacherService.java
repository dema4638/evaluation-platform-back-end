package com.swedbank.academy.evaluationplatform.teacher;

import java.util.List;

public interface TeacherService {

    public List<Teacher> getTeachers();

    void addTeacher(Teacher teacher);
}
