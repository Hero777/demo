package ee.example.demo.controller;

import ee.example.demo.domain.Customer;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @PostMapping
    public String save(@RequestBody Customer customer) {
        System.out.println("Customer " + customer.getLastName() + " added");
        return "Customer " + customer.getFirstName() + " saved to db.";
    }

    @GetMapping
    public List<Customer> getAll() {
        System.out.println("Get all customers.");
        return List.of(new Customer(1, "Oleg", "Petrov"));
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
    public Customer getById(@PathVariable int id) {
        System.out.println("Get customer with id = " + id);
        return new Customer(1,"Oleg", "Sidorov");
    }
}
