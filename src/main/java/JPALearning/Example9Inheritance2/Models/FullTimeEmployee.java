package JPALearning.Example9Inheritance2.Models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "FT_EMP")
@DiscriminatorValue("2")
public class FullTimeEmployee extends CompanyEmployee {
    private long salary;
    private long pension;

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public long getPension() {
        return pension;
    }

    public void setPension(long pension) {
        this.pension = pension;
    }
}
