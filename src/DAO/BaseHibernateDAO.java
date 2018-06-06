package DAO;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import service.HibernateSession;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class BaseHibernateDAO {
    protected void add(Object object){
        Session session;
        Transaction transaction;

        session= HibernateSession.getSession();
        transaction = session.beginTransaction();
        session.save(object);
        transaction.commit();
        session.close();
    }

    protected void delete(Object object){
        Session session;
        Transaction transaction;

        session = HibernateSession.getSession();
        transaction = session.beginTransaction();
        session.delete(object);
        transaction.commit();
        session.close();
    }

    protected List searchByObj(Class cla, Object condition){
        Session session;
        List list;

        session = HibernateSession.getSession();
        list = session.createCriteria(cla).add(Example.create(condition)).list();

        session.close();

        return list;
    }

//    protected List searchByName(Class cla, String name){
//        Session session;
//        List list;
//
//        session = HibernateSession.getSession();
//        list = session.createCriteria(cla).add(Restrictions.eq(name, )).list();
//    }

}
