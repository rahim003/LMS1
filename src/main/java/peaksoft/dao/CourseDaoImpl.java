package peaksoft.dao;

import org.springframework.stereotype.Repository;
import peaksoft.model.Course;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Map;

@Repository
public class CourseDaoImpl implements CourseDao {
    @PersistenceContext
    private EntityManager manager;

    @Override
    public Course saveCourse(Course course) {
        manager.merge(course);
        return course;
    }

    @Override
    public void updateCourse(long id, Course course) {
        Course course1=getById(id);
        course1.setCourseName(course.getCourseName());
        course1.setDirection(course.getDirection());
        course1.setCompanyId(course.getCompanyId());
        manager.merge(course1);
    }

    @Override
    public Course getById(long id) {
        return manager.find(Course.class,id);
    }

    @Override
    public void deleteById(long id) {
    manager.remove(getById(id));
    }

    @Override
    public List<Course> courses(long id) {
        return manager.createQuery("select course from Course course where course.company.id=:id",Course.class).setParameter("id",id).getResultList();

    }
}
