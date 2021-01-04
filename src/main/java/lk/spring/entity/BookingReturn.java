package lk.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class BookingReturn {
    @Id
    private String Invoice;
    private double km;
    private String note;
    private double total;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "bookingId", referencedColumnName = "bookingId", nullable = false)
    private Booking booking;

}
