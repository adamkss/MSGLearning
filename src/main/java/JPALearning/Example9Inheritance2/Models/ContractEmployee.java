package JPALearning.Example9Inheritance2.Models;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "CONTRACT_EMP")
@DiscriminatorValue("1")
public class ContractEmployee extends Employee {
    @Column(name = "D_RATE")
    private int dailyRate;

    private int term;

    public int getDailyRate() {
        return dailyRate;
    }

    public void setDailyRate(int dailyRate) {
        this.dailyRate = dailyRate;
    }

    public int getTerm() {
        return term;
    }

    public void setTerm(int term) {
        this.term = term;
    }
}
