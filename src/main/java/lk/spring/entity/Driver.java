package lk.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Driver {
    @Id
    private String driverId;
    private String name;
    private String nic;
    private String license;
    private String email;
    private int phone;
    private String Address;
    private String nicf;
    private String nicb;
    private String licef;
    private String liceb;



    @OneToMany(mappedBy = "driver")
    private List<Booking> orders = new ArrayList<>();

}
