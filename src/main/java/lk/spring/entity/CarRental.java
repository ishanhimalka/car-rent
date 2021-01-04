package lk.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class CarRental {
    @Id
    private String crid;
    private double deposite;
    private double dailyRate;
    private double dayFreeKM;
    private double monthlyRate;
    private double monthlyFreeKM;
    private double priceForExtraKm;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "carNumber", referencedColumnName = "carNumber", nullable = false)
    private Car car;
}
