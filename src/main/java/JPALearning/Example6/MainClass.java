package JPALearning.Example6;

import JPALearning.Example5.Models.Product;
import JPALearning.Example5.Models.ShoppingCart;
import JPALearning.Example5.Models.ShoppingCartItem;
import JPALearning.Example6.Models.Address;
import JPALearning.Example6.Models.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MainClass {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("example6");

        Address address1 = new Address();
        address1.setCity("Salonta");
        address1.setState("Romania");
        address1.setZip("415500");
        address1.setStreet("Jokai mor");

        Employee employee1 = new Employee();
        employee1.setAddress(address1);
        employee1.setName("Robi");
        employee1.setSalary(1222);


        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(employee1);
        entityManager.getTransaction().commit();
        entityManagerFactory.close();
    }
}
