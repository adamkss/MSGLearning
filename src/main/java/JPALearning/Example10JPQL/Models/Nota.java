package JPALearning.Example10JPQL.Models;

import javax.persistence.*;

@Entity
@Table(name = "NOTE")
public class Nota {
    @Id
    @GeneratedValue
    private int id;
    private int nota;
    @ManyToOne
    private Student student;

    public Nota() {

    }

    public Nota(int nota, Student student) {
        this.nota = nota;
        this.student = student;
    }
    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Nota{" +
                "id=" + id +
                ", nota=" + nota +
                ", student=" + student +
                '}';
    }
}
