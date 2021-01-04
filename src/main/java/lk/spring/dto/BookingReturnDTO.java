package lk.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookingReturnDTO {
    private String Invoice;
    private String bookingId;
    private double km;
    private String note;
    private double total;
}
