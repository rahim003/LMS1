package peaksoft.dao;

import peaksoft.model.Course;

import java.util.List;

public interface CourseDao {
    Course saveCourse(Course course);

    void updateCourse(long id, Course course);

    Course getById(long id);

    void deleteById(long id);

    List<Course> getAllCourse(long id);
}
