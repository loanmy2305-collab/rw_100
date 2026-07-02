package org.example.repository.impl;

import org.example.entity.Group;
import org.example.entity.GroupAccount;
import org.example.repository.IAccountRepository;
import org.example.repository.IGroupAccountRepository;
import org.example.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.time.LocalDateTime;
import java.util.List;

public class GroupAccountRepositoryImpl implements IGroupAccountRepository {
    private final SessionFactory sessionFactory = HibernateUtils.sessionFactory;


    @Override
    public List<GroupAccount> findAll() {
        Session session = sessionFactory.openSession();
        String hql = "FROM GroupAccount";
        Query<GroupAccount> query = session.createQuery(hql, GroupAccount.class);
        List<GroupAccount> groupAccounts = query.list();
        return groupAccounts;
    }

    @Override
    public GroupAccount findById(Integer id) {
        Session session = sessionFactory.openSession();
//        String hql = "FROM Group a where id = :idParam";
//        Query<Group> query = session.createQuery(hql, Group.class);
//        query.setParameter("idParam", id);
//        return query.uniqueResult();
        GroupAccount groupAccount = session.find(GroupAccount.class, id);
        session.close();
        return new GroupAccount();
    }

    @Override
    public void create(GroupAccount groupAccount) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            session.persist(groupAccount);

            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public void update(Integer id, LocalDateTime updateDate) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {

            GroupAccount groupAccount = session.find(GroupAccount.class, id);

            groupAccount.setJoinDate(updateDate);

            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public void delete(Integer id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            GroupAccount groupAccount = session.find(GroupAccount.class, id);

            session.persist(groupAccount);

            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }

    }
}
