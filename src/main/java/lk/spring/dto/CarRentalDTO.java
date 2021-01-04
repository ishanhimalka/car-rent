package lk.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CarRentalDTO {
    private String crid;
    private double deposite;
    private double dailyRate;
    private double dayFreeKM;
    private double monthlyRate;
    private double monthlyFreeKM;
    private double priceForExtraKm;
    private String carNumber;

}
