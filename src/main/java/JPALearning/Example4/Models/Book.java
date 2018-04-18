package JPALearning.Example4.Models;

import javax.persistence.*;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    private String nume;

    @OneToOne
    private BookDescription bookDescription;

    public Book() {
    }

    public Book(String nume, BookDescription bookDescription) {

        this.nume = nume;
        this.bookDescription = bookDescription;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public BookDescription getBookDescription() {
        return bookDescription;
    }

    public void setBookDescription(BookDescription bookDescription) {
        this.bookDescription = bookDescription;
    }
}
