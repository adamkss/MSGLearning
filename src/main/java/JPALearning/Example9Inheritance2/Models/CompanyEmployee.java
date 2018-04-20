package JPALearning.Example9Inheritance2.Models;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class CompanyEmployee extends Employee {
    private int vacation;

    public int getVacation() {
        return vacation;
    }

    public void setVacation(int vacation) {
        this.vacation = vacation;
    }
}
