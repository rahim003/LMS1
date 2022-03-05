package peaksoft.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import peaksoft.dao.CourseDaoImpl;
import peaksoft.model.Course;

import java.beans.Transient;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    private CourseDaoImpl courseDao;

    @Autowired
    public CourseServiceImpl(CourseDaoImpl courseDao) {
        this.courseDao = courseDao;
    }

    @Transactional
    @Override
    public Course saveCourse(Course course) {
        return courseDao.saveCourse(course);
    }

    @Transactional
    @Override
    public void updateCourse(long id, Course course) {
        courseDao.updateCourse(id,course);
    }

    @Transactional
    @Override
    public Course getById(long id) {
        return courseDao.getById(id);
    }

    @Transactional
    @Override
    public void deleteById(long id) {
        courseDao.deleteById(id);
    }

    @Transactional
    @Override
    public List<Course> courses(long id) {
        return courseDao.courses(id);
    }
}
