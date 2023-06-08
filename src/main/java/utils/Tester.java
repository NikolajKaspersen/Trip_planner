package utils;

import entities.Guide;
import entities.Role;
import entities.Trip;
import entities.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Tester {

  public static void main(String[] args) {

    EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory();
    EntityManager em = emf.createEntityManager();

    User u1 = new User("user", "test", "gadevej", "12345678", "mail.com", "2000", "human");
    User u2 = new User("admin", "test", "vejgade", "23456789", "mail.com", "2001", "human");

    Role userRole = new Role("user");
    Role adminRole = new Role("admin");

    Guide g1 = new Guide("Hans", "Human", "12/12/1985", "Profile1", "Image");
    Guide g2 = new Guide("Ben", "Human", "12/12/1985", "Profile2", "Image");

    Trip t1 = new Trip("Around Copenhagen", "06/06/2020", "12:00", "Rådhuspladsen", "4 hours", "PackingList", g1.getId());
    Trip t2 = new Trip("Around Aarhus", "06/06/2020", "13:00", "Rådhuspladsen", "5 hours", "PackingList", g2.getId());

    em.getTransaction().begin();
    u1.addRole(userRole);
    u2.addRole(adminRole);

//    t1.addUser(u1);
//    t1.addGuide(g1.getId());
//    t2.addUser(u2);
//    t2.addGuide(g2.getId());

    em.persist(u1);
    em.persist(u2);
    em.persist(userRole);
    em.persist(adminRole);
    em.persist(g1);
    em.persist(g2);
    em.persist(t1);
    em.persist(t2);

    em.getTransaction().commit();


    System.out.println(u1);
    System.out.println(u2);
    System.out.println(t1);
    System.out.println(t2);
    System.out.println(g1);
    System.out.println(g2);
    em.close();




   
  }

}
