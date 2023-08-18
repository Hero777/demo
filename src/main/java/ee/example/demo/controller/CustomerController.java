package ee.example.demo.controller;

import ee.example.demo.domain.CustomerDAO;
import ee.example.demo.domain.CustomerDTO;
import ee.example.demo.domain.CustomerService;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {

    @Resource
    private CustomerService customerService;

    @PostMapping
    public CustomerDAO save(@RequestBody CustomerDTO customerDTO) {

        return customerService.save(customerDTO);
    }

    @GetMapping
    public List<CustomerDTO> getAll() {
        System.out.println("Get all customers.");
        return List.of(new CustomerDTO( "Oleg", "Petrov"));
    }

    @PutMapping
    public String changeLastName(@RequestParam int id, @RequestParam String lastName) {

        System.out.println("Change lastname to " + lastName);
        return "Lastname is change.";
    }

    @DeleteMapping
    public String delete(@RequestParam int id) {
        System.out.println("Deleted customer with id = " + id);
        return "Successfully deleted.";
    }

    @GetMapping("/{id}")
    public CustomerDTO getById(@PathVariable int id) {
        System.out.println("Get customer with id = " + id);
        return new CustomerDTO("Oleg", "Sidorov");
    }
}
