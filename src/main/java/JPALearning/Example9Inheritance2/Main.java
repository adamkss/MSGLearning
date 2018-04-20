package JPALearning.Example9Inheritance2;

import JPALearning.Example9Inheritance2.Models.ContractEmployee;
import JPALearning.Example9Inheritance2.Models.Employee;
import JPALearning.Example9Inheritance2.Models.FullTimeEmployee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("example9");

        FullTimeEmployee fullTimeEmployee1 = new FullTimeEmployee();
        fullTimeEmployee1.setName("Robi");
        fullTimeEmployee1.setPension(1);
        fullTimeEmployee1.setSalary(400);
        fullTimeEmployee1.setVacation(16);
        fullTimeEmployee1.setStartDate(new Date(2001,11,2));

        ContractEmployee contractEmployee = new ContractEmployee();
        contractEmployee.setName("Cristi");
        contractEmployee.setDailyRate(233);
        contractEmployee.setTerm(100);
        contractEmployee.setStartDate(new Date(2005,10,10));

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(fullTimeEmployee1);
        entityManager.persist(contractEmployee);
        entityManager.getTransaction().commit();

        Employee contractEmployee1Employee = entityManager.find(ContractEmployee.class,2);
        System.out.println(contractEmployee.getName());

        entityManager.getTransaction().begin();
        contractEmployee1Employee.setName("George");
        entityManager.getTransaction().commit();

        entityManagerFactory.close();

    }
}
