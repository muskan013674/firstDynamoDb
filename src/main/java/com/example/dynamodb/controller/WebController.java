package com.example.dynamodb.controller;

import com.example.dynamodb.model.Customer;
import com.example.dynamodb.repo.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
public class WebController {

    @Autowired
    CustomerRepository repository;

    @RequestMapping("/delete")
    public String delete() {
        repository.deleteAll();
        return "Done";
    }

    @RequestMapping("/save")
    public String save() {
        // save a single Customer
        repository.save(new Customer("JSA-1", "Jack", "Smith"));
        repository.save(new Customer("JSA-2", "Jacky", "Smaht"));

        // save a list of Customers
//        repository.save(Arrays.asList(
//                new Customer("JSA-2", "Adam", "Johnson"),
//                new Customer("JSA-3", "Kim", "Smith"),
//                new Customer("JSA-4", "David", "Williams"),
//                new Customer("JSA-5", "Peter", "Davis")));

        return "Done";
    }

    @RequestMapping("/findall")
    public String findAll() {
        String result = "";
        Iterable<Customer> customers = repository.findAll();

        for (Customer cust : customers) {
            result += cust.toString() + "<br>";
        }

        return result;
    }

    @RequestMapping("/findbyid")
    public String findById(@RequestParam("id") String id) {
        String result = "";
        result = repository.findById(id).toString();
        return result;
    }

    @RequestMapping("/findbylastname")
    public String fetchDataByLastName(@RequestParam("lastname") String lastName) {
        String result = "";

        for (Customer cust : repository.findByLastName(lastName)) {
            result += cust.toString() + "<br>";
        }

        return result;
    }
}
