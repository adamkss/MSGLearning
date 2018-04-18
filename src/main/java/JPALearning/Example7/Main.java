package JPALearning.Example7;


import JPALearning.Example7.Models.Employee;
import JPALearning.Example7.Models.Project;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("example7");

        Project seriousProject1 = new Project("project1");
        Project seriousProject2 = new Project("project2");

        Employee employee1 = new Employee("Robi");
        Employee employee2 = new Employee("Cristi");

        employee1.getProjects().add(seriousProject1);
        employee1.getProjects().add(seriousProject2);
        employee2.getProjects().add(seriousProject1);
        employee2.getProjects().add(seriousProject2);

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(seriousProject1);
        entityManager.persist(seriousProject2);
        entityManager.persist(employee1);
        entityManager.persist(employee2);
        entityManager.getTransaction().commit();

        entityManager.getTransaction().begin();
        employee1.setName("kako");
        entityManager.getTransaction().commit();

        entityManagerFactory.close();

    }
}
