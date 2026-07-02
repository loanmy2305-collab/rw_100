package org.example;

import org.example.entity.Department;
import org.example.entity.Position;
import org.example.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        SessionFactory sessionFactory = HibernateUtils.sessionFactory;
        Session session = sessionFactory.openSession();
        Department department = session.find(Department.class, 1);
        System.out.println(department);

//        SessionFactory sessionFactory = HibernateUtils.sessionFactory;
//        Session session = sessionFactory.openSession();
//        Position position = session.find(Position.class, 1);
//        System.out.println(position);
   }
}
