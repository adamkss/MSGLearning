package JPALearning.Example2;

import JPALearning.Example2.Models.Department;
import JPALearning.Example2.Models.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MainClass {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("example2");

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