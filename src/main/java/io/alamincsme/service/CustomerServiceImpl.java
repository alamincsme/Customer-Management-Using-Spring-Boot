package io.alamincsme.service;

import io.alamincsme.model.Customer;
import io.alamincsme.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerRepository repo;

    @Override
    public List<Customer> allCustomer() {
        return (List<Customer>) repo.findAll();
    }

    @Override
    public void save(Customer customer) {
        repo.save(customer);
    }

    @Override
    public Customer getId(Integer id) throws CustomerNotFoundException {
        Optional<Customer> customer = repo.findById(id);
        if (customer.isPresent()) {
            return customer.get();
        }
        throw  new CustomerNotFoundException("Could not find any customer with id " + id );
    }

    @Override
    public void deleteCustomer(Integer id) throws CustomerNotFoundException {
        Long count  = repo.countById(id);
        if (count == null || count == 0) {
            throw  new CustomerNotFoundException("Could not find any customer with id " + id );
        } else {
            repo.deleteById(id);
        }


    }

    @Override
    public List<Customer> search(String searchWord) {
        return repo.findByCustomerNameContainingOrCustomerEmailContaining(searchWord, searchWord);
    }
}
