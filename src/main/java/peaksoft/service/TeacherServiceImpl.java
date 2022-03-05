package peaksoft.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import peaksoft.dao.TeacherDaoImpl;
import peaksoft.model.Teacher;

import java.util.List;
@Service
public class TeacherServiceImpl implements TeacherService{
    private TeacherDaoImpl teacherDao;
    @Autowired
    public TeacherServiceImpl(TeacherDaoImpl teacherDao) {
        this.teacherDao = teacherDao;
    }
    @Transactional
    @Override
    public Teacher save(Teacher teacher) {
        return teacherDao.save(teacher);
    }
    @Transactional
    @Override
    public void updateTeacher(long id,Teacher teacher) {
     teacherDao.updateTeacher(id,teacher);
    }
@Transactional
    @Override
    public Teacher getById(long id) {
        return teacherDao.getById(id)
                ;
    }
@Transactional
    @Override
    public void deleteById(long id) {
  teacherDao.deleteById(id);
    }
@Transactional
    @Override
    public List<Teacher> teachers(long id) {
        return teacherDao.teachers(id);
    }
}
