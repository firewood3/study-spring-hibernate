package com.gchsj.dao;

import com.gchsj.entity.Student;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;

public class StudentDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public void persist(Student student) {
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }

        session.persist(student);
    }
}
