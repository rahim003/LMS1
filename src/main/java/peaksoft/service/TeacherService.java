package peaksoft.service;

import peaksoft.model.Teacher;

import java.util.List;

public interface TeacherService {
    Teacher save(Teacher teacher);
    void updateTeacher(long id,Teacher teacher);
    Teacher getById(long id);
    void deleteById(long id);
    List<Teacher>teachers(long id);
}
