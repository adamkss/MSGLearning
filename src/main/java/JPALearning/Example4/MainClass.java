package JPALearning.Example4;

import JPALearning.Example3.Models.Department;
import JPALearning.Example3.Models.Employee;
import JPALearning.Example4.Models.Book;
import JPALearning.Example4.Models.BookDescription;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MainClass {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("example4");

        BookDescription bookDescription1 = new BookDescription("first");
        Book firstBook = new Book("first book", bookDescription1);

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(bookDescription1);
        entityManager.persist(firstBook);
        entityManager.getTransaction().commit();
        entityManagerFactory.close();
    }
}
