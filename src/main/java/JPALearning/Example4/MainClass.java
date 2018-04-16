package JPALearning.Example3;

import JPALearning.Example1.Models.Bank;
import JPALearning.Example1.Models.Client;
import JPALearning.Example3.Models.Department;
import JPALearning.Example3.Models.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MainClass {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");

        Department contabilitate = new Department();
        contabilitate.setName("contabilitate");

        Employee robi=new Employee();
        robi.setNume("robi");
        robi.setDepartment(contabilitate);

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(contabilitate);
        entityManager.persist(robi);
        entityManager.getTransaction().commit();
        entityManagerFactory.close();
    }
}
