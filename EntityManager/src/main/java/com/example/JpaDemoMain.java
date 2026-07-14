package com.example;

import jakarta.persistence.EntityManager;

public class JpaDemoMain {
    
    @SuppressWarnings("CallToPrintStackTrace")
    public static void main(String[] args) {

        EntityManager em = JpaUtil.getEntityManager();
        
        try{
            UserClassJpa user = new UserClassJpa("Rahul");
            em.getTransaction().begin();
            em.persist(user); //save(user)
            em.getTransaction().commit();
            System.out.println("User saved : " + user.getId());
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            em.close();
            JpaUtil.close();

        }
    }
}
