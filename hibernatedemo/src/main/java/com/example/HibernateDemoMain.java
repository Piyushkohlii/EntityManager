package com.example;

import org.hibernate.Session;

public class HibernateDemoMain {
    
    @SuppressWarnings("CallToPrintStackTrace")
    public static void main(String[] args) {
        
        Session session = HibernateUtil.getSession();

        try {
            UserClassHibernate user = new UserClassHibernate("Piyush");
            session.beginTransaction();
            session.persist(user); //save(user)
            session.getTransaction().commit();
            System.out.println("User saved" + user.getId());
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            HibernateUtil.close();
        }
    }
}
