package JPALearning.Example4.Models;

import javax.persistence.*;

@Entity
@Table(name = "book_descriptions")
public class BookDescription {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    private String theBookDescription;

    public BookDescription() {
    }

    public BookDescription(String bookDescription) {
        this.theBookDescription = bookDescription;
    }

    @OneToOne(mappedBy = "bookDescription")
    private Book book;

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTheBookDescription() {
        return theBookDescription;
    }

    public void setTheBookDescription(String bookDescription) {
        this.theBookDescription = bookDescription;
    }
}
