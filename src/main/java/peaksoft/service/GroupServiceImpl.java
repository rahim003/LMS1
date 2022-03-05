package peaksoft.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import peaksoft.dao.GroupDaoImpl;
import peaksoft.model.Group;

import javax.persistence.Table;
import java.util.List;

@Service
public class GroupServiceImpl implements GroupService{
    private final GroupDaoImpl groupDao;
@Autowired
    public GroupServiceImpl(GroupDaoImpl groupDao) {
        this.groupDao = groupDao;
    }

    @Override
    public Group saveGroup(Group group) {
        return groupDao.saveGroup(group);
    }
  @Transactional
    @Override
    public void updateGroup(long id,Group group) {
    groupDao.updateGroup(id,group);
    }
@Transactional
    @Override
    public Group getById(long id) {
        return groupDao.getById(id);
    }
@Transactional
    @Override
    public void deleteById(long id) {
    groupDao.deleteById(id);

    }
@Transactional
    @Override
    public List<Group> groups() {
        return groupDao.groups();
    }
}
