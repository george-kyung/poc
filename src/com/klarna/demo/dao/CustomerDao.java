package com.klarna.demo.dao;

import com.klarna.demo.entity.Customer;

public interface CustomerDao {
    void save(Customer customer);

    Customer findBySocialSecurityNumber(String socialSecurityNumber);
}
