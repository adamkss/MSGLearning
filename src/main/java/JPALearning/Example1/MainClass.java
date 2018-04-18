package JPALearning.Example1;

import JPALearning.Example1.Models.Bank;
import JPALearning.Example1.Models.Client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MainClass {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("example1");

        Client a=new Client();
        a.setName("robi");

        Bank b=new Bank();
        b.setName("Transilvania");

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(a);
        entityManager.persist(b);
        entityManager.getTransaction().commit();
        entityManagerFactory.close();
    }
}
