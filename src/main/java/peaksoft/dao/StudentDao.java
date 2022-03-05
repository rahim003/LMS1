package peaksoft.dao;

import peaksoft.model.Student;

import java.util.List;

public interface StudentDao {
    Student saveStudent(Student student);

    void updateStudent(long id, Student student);

    Student getById(long id);

    void deleteById(long id);

    List<Student> students();
}
