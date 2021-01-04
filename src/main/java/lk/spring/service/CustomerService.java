package lk.spring.service;

import lk.spring.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {
    void saveCustomer(CustomerDTO dto);

    void updateCustomer(CustomerDTO dto);

    CustomerDTO searchCustomer(String customerregitor);

    void deleteCustomer(String customerregitor);

    List<CustomerDTO> getAllCustomer();
}
