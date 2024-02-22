package io.alamincsme.repository;

import io.alamincsme.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    Long countById(Integer id);

    List<Customer> findByCustomerNameContainingOrCustomerEmailContaining(String customerName, String customerEmil);
}
