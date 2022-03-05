package peaksoft.dao;

import peaksoft.model.Teacher;

import java.util.List;

public interface TeacherDao {
    Teacher save(Teacher teacher);

    void updateTeacher(long id, Teacher teacher);

    Teacher getById(long id);

    void deleteById(long id);

    List<Teacher> teachers(long id);
}
