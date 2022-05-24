package peaksoft.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import peaksoft.model.Course;
import peaksoft.model.Group;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class GroupDaoImpl implements GroupDao {
    @PersistenceContext
    private EntityManager manager;

    @Override
    public Group saveGroup(Group group) {
        manager.merge(group);
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
        return manager.find(Group.class, id);
    }

    @Override
    public void deleteById(long id) {
        manager.createQuery("delete from Group where id=: id").setParameter("id", id).executeUpdate();
    }

    @Override
    public List<Group> getAllGroup(long id) {
        return manager.find(Course.class, id).getGroupList();
    }
}
