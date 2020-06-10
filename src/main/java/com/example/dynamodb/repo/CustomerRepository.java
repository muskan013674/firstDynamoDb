package com.example.dynamodb.repo;

import com.example.dynamodb.model.Customer;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
@EnableScan
public interface CustomerRepository extends CrudRepository<Customer, String> {

    List<Customer> findByLastName(String lastName);

}
