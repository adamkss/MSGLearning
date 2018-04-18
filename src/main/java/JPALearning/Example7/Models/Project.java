package JPALearning.Example7.Models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "PROJECTS")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    public Project(String name) {
        this.name = name;
    }

    public Project() {
    }

    @ManyToMany(mappedBy = "projects")
    private List<Employee> employees = new ArrayList<>();
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
