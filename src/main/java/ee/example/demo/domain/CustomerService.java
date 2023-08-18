package ee.example.demo.domain;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CustomerService {

    @Resource
    private CustomerRepository customerRepository;

    public CustomerDAO save(CustomerDTO customerDTO) {

        System.out.println("Customer " + customerDTO.getLastName() + " added");

        CustomerDAO customerDAO = new CustomerDAO();
        customerDAO.setFirstName(customerDTO.getFirstName());
        customerDAO.setLastName(customerDTO.getLastName());
        customerDAO.setCreatedAt(LocalDateTime.now());

        return customerRepository.save(customerDAO);
    }
}
