package com.klarna.demo.dao;

import com.klarna.demo.entity.Customer;

import java.util.ArrayList;
import java.util.List;

public class Session {
    private List<Customer> customers = new ArrayList<>();

    public void save(Customer customer) {
        customer.setId(customers.size() == 0 ? 1 : customers.get(customers.size() - 1).getId() + 1);
        customers.add(customer);
    }

    public Customer get(String socialSecurityNumber) {
        Customer customer = customers.stream().filter(c -> c.getSocialSecurityNumber().equals(socialSecurityNumber)).findFirst().orElse(null);
        return customer;
    }
}
