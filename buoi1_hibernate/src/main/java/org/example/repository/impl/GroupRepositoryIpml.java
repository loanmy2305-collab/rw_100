package org.example.repository.impl;

import org.example.entity.Account;
import org.example.entity.Department;
import org.example.entity.Group;
import org.example.repository.IGroupRepository;
import org.example.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;



public class GroupRepositoryIpml implements IGroupRepository {
    private final SessionFactory sessionFactory = HibernateUtils.sessionFactory;

    @Override
    public List<Group> findAll() {
        Session session = sessionFactory.openSession();
        String hql = "FROM Group";
        Query<Group> query = session.createQuery(hql, Group.class);
        List<Group> groups = query.list();
        return groups;
    }

    @Override
    public Group findById(Integer id) {
        Session session = sessionFactory.openSession();
//        String hql = "FROM Group a where id = :idParam";
//        Query<Group> query = session.createQuery(hql, Group.class);
//        query.setParameter("idParam", id);
//        return query.uniqueResult();
        Group group = session.find(Group.class, id);
        session.close();
        return new Group();
    }

    @Override
    public void create(Group group) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            session.persist(group);

            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }

    }

    @Override
    public void update(Integer id, String updateName) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {

            Group group = session.find(Group.class, id);
            group.setGroupName(updateName);

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
            Group group = session.find(Group.class, id);

            session.persist(group);

            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }

    }
}
