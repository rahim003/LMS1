package peaksoft.dao;

import peaksoft.model.Group;

import java.util.List;

public interface GroupDao {
    Group saveGroup(Group group);

    void updateGroup(long id, Group group);

    Group getById(long id);

    void deleteById(long id);

    List<Group> getAllGroup(long id);
}
