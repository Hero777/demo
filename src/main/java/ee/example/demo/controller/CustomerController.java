package ee.example.demo.controller;

import ee.example.demo.domain.Customer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    @PostMapping("/addCustomer")
    public String save(@RequestBody Customer customer) {
        System.out.println("Customer " + customer.getLastName() + " added");
        return "Customer " + customer.getFirstName() + " saved to db.";
    }
}
