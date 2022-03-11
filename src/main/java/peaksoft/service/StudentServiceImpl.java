package peaksoft.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import peaksoft.dao.StudentDaoImpl;
import peaksoft.model.Student;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    private StudentDaoImpl studentDao;

    @Autowired
    public StudentServiceImpl(StudentDaoImpl studentDao) {
        this.studentDao = studentDao;
    }

    @Transactional
    @Override
    public Student saveStudent(Student student) {
        return studentDao.saveStudent(student);
    }

    @Transactional
    @Override
    public void updateStudent(long id, Student student) {
        studentDao.updateStudent(id, student);
    }

    @Transactional
    @Override
    public Student getById(long id) {
        return studentDao.getById(id);
    }

    @Transactional
    @Override
    public void deleteById(long id) {
        studentDao.deleteById(id);
    }

    @Transactional
    @Override
    public List<Student> getAllStudent(long id) {
        return studentDao.getAllStudent(id);
    }
}
