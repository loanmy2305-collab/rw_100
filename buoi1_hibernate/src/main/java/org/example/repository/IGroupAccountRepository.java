package org.example.repository;

import org.example.entity.Group;
import org.example.entity.GroupAccount;

import java.time.LocalDateTime;
import java.util.List;

public interface IGroupAccountRepository {
    List<GroupAccount> findAll();
    GroupAccount findById(Integer id);
    void create(GroupAccount groupAccount);
    void update(Integer id, LocalDateTime updateDate);
    void delete(Integer id);
}
