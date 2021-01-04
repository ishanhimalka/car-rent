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
public class Booking{
    @Id
    private String bookingId;
    private String dateTime;
    private String duration;
    private String bankSlip;
    private String pickupnote;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "CustomerID" , referencedColumnName = "customerregitor" ,nullable = false)
    private Customer customer;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "DriverID", referencedColumnName = "driverId", nullable = false)
    private Driver driver;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "carId", referencedColumnName = "carNumber", nullable = false)
    private Car car;

    @OneToMany(mappedBy = "booking" ,fetch = FetchType.LAZY)
    private List<BookingReturn> bookingReturnList =new ArrayList<>();
}
