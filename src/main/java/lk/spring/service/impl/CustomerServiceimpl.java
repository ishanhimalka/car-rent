package lk.spring.service.impl;

import lk.spring.dto.CustomerDTO;
import lk.spring.entity.Customer;
import lk.spring.repo.CustomerRepo;
import lk.spring.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CustomerServiceimpl implements CustomerService {

    @Autowired
    CustomerRepo customerRepo;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public void saveCustomer(CustomerDTO dto) {
        if (customerRepo.existsById(dto.getCustomerregitor())) {
            customerRepo.save(modelMapper.map(dto, Customer.class));
        } else {
            throw new RuntimeException("Customer Not Found!");
        }
    }

    @Override
    public void updateCustomer(CustomerDTO dto) {
        if (customerRepo.existsById(dto.getCustomerregitor())) {
            customerRepo.save(modelMapper.map(dto, Customer.class));
        } else {
            throw new RuntimeException("Customer Not Found!");
        }
    }

    @Override
    public CustomerDTO searchCustomer(String customerregitor) {
        Optional<Customer> customer = customerRepo.findById(customerregitor);
        if (customer.isPresent()) {
            return modelMapper.map(customer.get(), CustomerDTO.class);
        } else {
            throw new RuntimeException("Customer does not exist!");
        }
    }

    @Override
    public void deleteCustomer(String customerregitor) {
        if (customerRepo.existsById(customerregitor)) {
            customerRepo.deleteById(customerregitor);
        } else {
            throw new RuntimeException("Couldn't to delete Customer!");
        }
    }

    @Override
    public List<CustomerDTO> getAllCustomer() {
        return modelMapper.map(customerRepo.findAll(), new TypeToken<List<CustomerDTO>>() {
        }.getType());
    }
}
