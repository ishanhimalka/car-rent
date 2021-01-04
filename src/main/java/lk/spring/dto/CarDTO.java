package lk.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CarDTO {
    private String carNumber;
    private int noOfPassengers;
    private String type;
    private String fuelType;
    private String brand;
    private String color;
    private String transmissionType;
    private String carImageurl1;
    private String carImageurl2;
    private String carImageurl3;
    private String carImageurl4;
}

