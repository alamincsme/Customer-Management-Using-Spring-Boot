package io.alamincsme.service;

import io.alamincsme.model.Customer;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CustomerService {

    public List<Customer> allCustomer() ;
    public void save(Customer customer) ;
    public Customer getId(Integer id) throws CustomerNotFoundException;
    public void deleteCustomer(Integer id) throws CustomerNotFoundException;


    List<Customer> search(String searchWord);
}
