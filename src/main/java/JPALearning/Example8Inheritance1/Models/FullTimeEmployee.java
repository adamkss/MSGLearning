package JPALearning.Example8Inheritance1.Models;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("FTemp")
public class FullTimeEmployee extends CompanyEmployee{
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
