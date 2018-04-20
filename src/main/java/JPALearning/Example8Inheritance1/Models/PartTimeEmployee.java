package JPALearning.Example8Inheritance1.Models;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("PTemp")
public class PartTimeEmployee extends CompanyEmployee{
    @Column(name = "H_RATE")
    private float hourlyRate;

    public float getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(float hourlyRate) {
        this.hourlyRate = hourlyRate;
    }
}
