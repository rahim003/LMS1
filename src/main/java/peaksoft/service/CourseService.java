package peaksoft.service;

import peaksoft.model.Course;

import java.util.List;

public interface CourseService {
    Course saveCourse(Course course);
    void updateCourse( long id,Course course);
    Course getById(long id);
    void deleteById(long id);
    List<Course>courses(long id);
}
