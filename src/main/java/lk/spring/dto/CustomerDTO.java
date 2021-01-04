package lk.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerDTO {
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
}

