package peaksoft.service;

import peaksoft.model.Group;

import java.util.List;

public interface GroupService {
    Group saveGroup(Group group);

    void updateGroup(long id, Group group);

    Group getById(long id);

    void deleteById(long id);

    List<Group> getAllGroup(long id);
}
