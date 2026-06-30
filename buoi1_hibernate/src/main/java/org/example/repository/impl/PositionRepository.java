package org.example.repository.impl;

import org.example.entity.Position;
import org.example.repository.IPositionRepository;
import org.example.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class PositionRepository  implements IPositionRepository {
    private final SessionFactory sessionFactory = HibernateUtils.sessionFactory;
    @Override
    public List<Position> findAll() {
        List<Position> positions = new ArrayList<>();
        Session session = sessionFactory.openSession();
        try {
            String hql = "From Position";
            Query<Position> query = session.createQuery(hql, Position.class);
            positions = query.list();// lay ds
        } finally {
            session.close();
        }
        return positions;
    }

    @Override
    public Position findById(Integer id) {
        Position position = new Position();
        Session session = sessionFactory.openSession();
        try {
            String hql = "From Position where id = :idParam";
            Query<Position> query = session.createQuery(hql, Position.class);
            query.setParameter("idParam", 1);
            position = query.uniqueResult();
        } finally {
            session.close();
        }

        return position;
    }

    @Override
    public void create(String name) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            Position position = new Position();
            position.setName(name);

            session.persist(position);
            // commit dữ liệu nếu thành công
            session.getTransaction().commit();
        } catch (Exception e) {
            // hoàn lại dữ liệu nếu gặp lỗi
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public void update(String updateName, Integer id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            // tifm ra department caafn update

            Position position = session.find(Position.class, id);

            position.setName(updateName);
            session.getTransaction().commit();
        } catch (Exception e) {
            // hoàn lại dữ liệu nếu gặp lỗi
            session.getTransaction().rollback();
        } finally {
            session.close();
        }

    }
}
