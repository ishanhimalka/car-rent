package lk.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Car {
    @Id
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

    @OneToMany(mappedBy = "car" ,  fetch = FetchType.LAZY)
    private List<Booking> bookingList =new ArrayList<>();

    @OneToMany(mappedBy = "car" ,  fetch = FetchType.LAZY)
    private List<CarRental> carRentals =new ArrayList<>();
}
