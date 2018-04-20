package JPALearning.Example10JPQL.Models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "STUDENTS")
public class Student {
    @Id
    @GeneratedValue
    private int id;
    private String nume;
    private int an;
    @OneToMany(mappedBy = "student")
    List<Nota> note = new ArrayList<>();


    public Student() {
    }

    public Student(String nume, int an) {

        this.nume = nume;
        this.an = an;
    }

    public int getAn() {
        return an;
    }

    public void setAn(int an) {
        this.an = an;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public List<Nota> getNote() {
        return note;
    }

    public void setNote(List<Nota> note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Student{" +
                "nume='" + nume + '\'' +
                ", an=" + an +
                '}';
    }
}
