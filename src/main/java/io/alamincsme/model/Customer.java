package io.alamincsme.model;

import jakarta.persistence.*;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;

    @Column(length = 45, unique = true, nullable = false)
    private String customerEmail;
    @Column(length = 45 , nullable = false)
    private String customerName;

    @Column(length = 100, nullable = false)
    private String customerAddress;


    public Customer() {

    }

    public Customer(int id, String customerEmail, String customerName, String customerAddress) {
        this.id = id;
        this.customerEmail = customerEmail;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }
}
