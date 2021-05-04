package com.gchsj.dao;

import com.gchsj.entity.Person;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;

public class PersonDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void printMessage() {
        System.out.println("PersonDao message");
    }

    @Transactional
    public void persist(Person person) {
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }

        session.persist(person);
    }
}
