package JPALearning.Example9Inheritance2.Models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "EMP")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "EMP_TYPE", discriminatorType = DiscriminatorType.INTEGER)
public abstract class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    @Temporal(TemporalType.DATE)
    @Column(name = "START_DATE")
    private Date startDate;

    public Employee() {
    }
    public Employee(String name, Date startDate) {

        this.name = name;
        this.startDate = startDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
}
