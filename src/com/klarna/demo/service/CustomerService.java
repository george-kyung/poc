package com.klarna.demo.service;

import com.klarna.demo.entity.Customer;
import com.klarna.demo.type.ChildData;

public interface CustomerService {

    void save(Customer customer) throws Exception;

    Customer findCustomerBySocialSecurityNumber(String socialSecurityNumber) throws Exception;

    ChildData findOldestChildBySocialSecurityNumber(String socialSecurityNumber) throws Exception;
}
