package com.klarna.demo.service;

import com.klarna.demo.dao.CustomerDao;
import com.klarna.demo.dao.CustomerDaoImpl;
import com.klarna.demo.entity.Customer;
import com.klarna.demo.type.Child;
import com.klarna.demo.type.ChildData;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Logger;

public class CustomerServiceImpl implements CustomerService {
    private static Logger logger = Logger.getLogger(CustomerServiceImpl.class.getName());
    private static CustomerDao customerDao = new CustomerDaoImpl();

    @Override
    public void save(Customer customer) throws Exception {
        if (customerDao.findBySocialSecurityNumber(customer.getSocialSecurityNumber()) != null) {
            throw new Exception("The same social security number already exists");
        }
        customerDao.save(customer);
        logger.info("Customer is saved");
    }

    @Override
    public Customer findCustomerBySocialSecurityNumber(String socialSecurityNumber) throws Exception {
        Customer customer = customerDao.findBySocialSecurityNumber(socialSecurityNumber);
        if (customer == null) {
            throw new Exception("No customer exists");
        }
        logger.info("Customer is found");
        return customer;
    }

    @Override
    public ChildData findOldestChildBySocialSecurityNumber(String socialSecurityNumber) throws Exception {
        Customer customer = findCustomerBySocialSecurityNumber(socialSecurityNumber);
        List<Child> children = customer.getChildren();

        Child oldestChild = null;
        if (children == null) {
            logger.info("Customer doesn't have children");
        } else {
            Collections.sort(children, new CompareChildren());
            oldestChild = children.get(0);
            logger.info("The oldest child is found");
        }
        return new ChildData(socialSecurityNumber, oldestChild);
    }

    private class CompareChildren implements Comparator<Child> {
        @Override
        public int compare(Child o1, Child o2) {
            return o2.getAge() - o1.getAge();
        }
    }

}
