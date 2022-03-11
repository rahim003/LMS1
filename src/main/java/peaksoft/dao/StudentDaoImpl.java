package peaksoft.dao;

import org.springframework.stereotype.Repository;
import peaksoft.model.Student;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class StudentDaoImpl implements StudentDao {
    @PersistenceContext
    private EntityManager manager;

    @Override
    public Student saveStudent(Student student) {
        manager.merge(student);
        return student;
    }

    @Override
    public void updateStudent(long id, Student student) {
        Student student1 = getById(id);
        student1.setFirstName(student.getFirstName());
        student1.setLastName(student.getLastName());
        student1.setEmail(student.getEmail());
        student1.setStudyFormat(student.getStudyFormat());
        manager.merge(student1);
    }

    @Override
    public Student getById(long id) {
        return manager.find(Student.class, id);
    }

    @Override
    public void deleteById(long id) {
        manager.remove(getById(id));
    }

    @Override
    public List<Student> getAllStudent(long id) {
        return    manager.createQuery("select student from Student student where student.group.id=:id", Student.class).setParameter("id", id).getResultList();
    }
}
