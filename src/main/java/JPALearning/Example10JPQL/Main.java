package JPALearning.Example10JPQL;

import JPALearning.Example10JPQL.Models.Nota;
import JPALearning.Example10JPQL.Models.Student;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("example10");

        List<Student> studentsToAdd = new ArrayList<>();
        studentsToAdd.add(new Student("Robi",3));
        studentsToAdd.add(new Student("Kati",1));
        studentsToAdd.add(new Student("George",4));
        studentsToAdd.add(new Student("Madalina",2));
        studentsToAdd.add(new Student("Malina",2));

        List<Nota> noteToAdd = new ArrayList<>();
        noteToAdd.add(new Nota(10, studentsToAdd.get(0)));
        noteToAdd.add(new Nota(5,studentsToAdd.get(1)));
        noteToAdd.add(new Nota(6,studentsToAdd.get(2)));
        noteToAdd.add(new Nota(9, studentsToAdd.get(3)));
        noteToAdd.add(new Nota(10,studentsToAdd.get(4)));

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        studentsToAdd.forEach(entityManager::persist);
        noteToAdd.forEach(entityManager::persist);
        entityManager.getTransaction().commit();

        TypedQuery<Nota> nota = entityManager.createQuery("SELECT n FROM Nota n", Nota.class);
        List<Nota> note = nota.getResultList();
        note.forEach(System.out::println);

        TypedQuery<Nota> notaQuery2 = entityManager.createQuery("SELECT n FROM Nota n JOIN n.student s WHERE s.nume='Kati'", Nota.class);
        List<Nota> noteResult2 = notaQuery2.getResultList();
        noteResult2.forEach(System.out::println);


        TypedQuery<Student> studentTypedQuery = entityManager.createQuery("SELECT s FROM Student s WHERE s.nume LIKE '%na'",Student.class);
        List<Student> students = studentTypedQuery.getResultList();
        students.forEach(System.out::println);

        entityManagerFactory.close();

    }
}
