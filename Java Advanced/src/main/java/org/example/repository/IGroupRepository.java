package org.example.repository;

import org.example.entity.Account;
import org.example.entity.Group;

import java.util.List;

public interface IGroupRepository {
    List<Group> findAll();
    Group findById(Integer id);
    void create(Group group);
    void update(Integer id, String updateName);
    void delete(Integer id);
}
