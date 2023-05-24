package edu.bzu.consumeAPI.rest;

import edu.bzu.consumeAPI.Customer;
import edu.bzu.consumeAPI.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/customer")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/customer")
    public Iterable<Customer> customerList() {
        Iterable<Customer> customerList = customerRepository.findAll();
        return customerList;
    }

//    @PostMapping("/customer")
//    public Iterable<Customer> create() {
//        Iterable<Customer> customerList = customerRepository.save();
//        return customerList;
//    }
}
