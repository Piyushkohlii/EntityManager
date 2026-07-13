package com.example;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


@SuppressWarnings("CallToPrintStackTrace")
public class HibernateUtil {
    private static SessionFactory sessionFactory;

    static{
        try{
            sessionFactory = new Configuration().configure("hibernate.cfg.xml")
                                                .addAnnotatedClass(UserClassHibernate.class)
                                                .buildSessionFactory();
        }catch(HibernateException e){
            e.printStackTrace();
        }
    }

    public static Session getSession(){
        return sessionFactory.getCurrentSession();

    }

    public static void close(){
        sessionFactory.close();
    }
}
