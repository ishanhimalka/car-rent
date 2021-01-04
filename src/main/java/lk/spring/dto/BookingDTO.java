package lk.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookingDTO {
    private String bookingId;
    private String customerregitor;
    private String carNumber;
    private String driver;
    private String dateTime;
    private String duration;
    private String bankSlip;
    private String pickupnote;

    public void setStatus(boolean b) {
    }
}
