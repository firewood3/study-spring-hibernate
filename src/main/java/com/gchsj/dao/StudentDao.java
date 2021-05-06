package com.gchsj.dao;

import com.gchsj.entity.Student;
import com.gchsj.types.Gender;
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
        session.persist(student); // persistent 상태로 만듦
        student.setGender(Gender.FEMALE);
        session.flush(); // commit 하여 영속화
        session.evict(student); // detached 상태로 만듦
        student.setGender(Gender.MALE);
        session.merge(student); // merge 하여 다시 persistent 상태로 만듦
        session.flush();
    }

    @Transactional
    public void flush() {
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
        session.flush();
    }

    @Transactional
    public void delete(Student student) {
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
        session.delete(student); // student를 Transient 상태로 만듦
    }
}
