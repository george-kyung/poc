package com.klarna.demo.dao;

import com.klarna.demo.entity.Customer;

public class CustomerDaoImpl implements CustomerDao {
    private static Session session = new Session();

    @Override
    public void save(Customer customer) {
        session.save(customer);
    }

    @Override
    public Customer findBySocialSecurityNumber(String socialSecurityNumber) {
        return session.get(socialSecurityNumber);
    }
}
