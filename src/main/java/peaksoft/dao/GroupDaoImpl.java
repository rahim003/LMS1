package peaksoft.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import peaksoft.model.Company;
import peaksoft.model.Course;
import peaksoft.model.Group;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
@Transactional
public class GroupDaoImpl implements GroupDao {
    @PersistenceContext
    private EntityManager manager;

    @Override
    public Group saveGroup(Group group) {
        List<Course>courses=new ArrayList<>();
        group.setCourseList(courses);
        manager.persist(group);
        return group;
    }

    @Override
    public void updateGroup(long id, Group group) {
        Group group1 = getById(id);
        group1.setGroupName(group.getGroupName());
        group1.setDateOfStart(group.getDateOfStart());
        group1.setDateOfFinish(group.getDateOfFinish());
        manager.merge(group1);
    }

    @Override
    public Group getById(long id) {
        return manager.find(Group.class,id);
    }

    @Override
    public void deleteById(long id) {
        manager.remove(getById(id));
    }

    @Override
    public List<Group> groups() {
        return  manager.createQuery("select gro from Group gro",Group.class).getResultList();

    }
}
