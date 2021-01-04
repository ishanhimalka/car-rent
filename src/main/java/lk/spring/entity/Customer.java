package lk.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Customer{
    @Id
    private String customerregitor;
    private String name;
    private String nic;
    private String license;
    private String email;
    private int phone;
    private String address;
    private String nicf;
    private String nicb;
    private String licef;
    private String liceb;

    @OneToMany(mappedBy = "customer" ,fetch = FetchType.LAZY)
    private List<Booking> bookingList =new ArrayList<>();



}
