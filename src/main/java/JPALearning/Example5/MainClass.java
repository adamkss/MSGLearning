package JPALearning.Example5;

import JPALearning.Example4.Models.Book;
import JPALearning.Example4.Models.BookDescription;
import JPALearning.Example5.Models.Product;
import JPALearning.Example5.Models.ShoppingCart;
import JPALearning.Example5.Models.ShoppingCartItem;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MainClass {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");

        Product produs1 = new Product();
        produs1.setName("Milka");

        Product produs2 = new Product();
        produs2.setName("Oreo");

        ShoppingCart robiShoppingCart = new ShoppingCart();

        ShoppingCartItem item1 = new ShoppingCartItem();
        item1.setProduct(produs1);
        item1.setShoppingCart(robiShoppingCart);


        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(produs1);
        entityManager.persist(robiShoppingCart);
        entityManager.persist(item1);
        entityManager.getTransaction().commit();
        entityManagerFactory.close();
    }
}
