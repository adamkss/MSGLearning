package JPALearning.Example9Inheritance2.Models;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "PT_EMP")
@DiscriminatorValue("3")
public class PartTimeEmployee extends CompanyEmployee {
    @Column(name = "H_RATE")
    private float hourlyRate;

    public float getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(float hourlyRate) {
        this.hourlyRate = hourlyRate;
    }
}
