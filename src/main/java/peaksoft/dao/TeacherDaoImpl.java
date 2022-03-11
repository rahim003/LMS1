package peaksoft.dao;

import org.springframework.stereotype.Repository;
import peaksoft.model.Teacher;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class TeacherDaoImpl implements TeacherDao {
    @PersistenceContext
    private EntityManager manager;

    @Override
    public Teacher save(Teacher teacher) {
        manager.merge(teacher);
        return teacher;
    }

    @Override
    public void updateTeacher(long id, Teacher teacher) {
        Teacher teacher1 = getById(id);
        teacher1.setFirstName(teacher.getFirstName());
        teacher1.setLastName(teacher.getLastName());
        teacher1.setEmail(teacher.getEmail());
        manager.merge(teacher1);
    }

    @Override
    public Teacher getById(long id) {
        return manager.find(Teacher.class, id);
    }

    @Override
    public void deleteById(long id) {
        manager.remove(getById(id));
    }

    @Override
    public List<Teacher> getAllTeacher(long id) {
        return manager.createQuery("select teachers from Teacher teachers where teachers.course.id=:id", Teacher.class).setParameter("id", id).getResultList();

    }
}
