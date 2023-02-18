package com.klarna;

import com.klarna.demo.entity.Customer;
import com.klarna.demo.service.CustomerService;
import com.klarna.demo.service.CustomerServiceImpl;
import com.klarna.demo.type.Child;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        CustomerService customerService = new CustomerServiceImpl();

        try {
            Child child = new Child(null, 0);
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            Child child = new Child("George", 0);
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            Customer customer = new Customer("199510103333", null, null, null);
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            Customer customer = new Customer("199510103333", "", null, null);
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            Customer customer = new Customer("199510995232", "George", null, null);
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            Customer customer = new Customer("19901023abcd", "George", null, null);
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            List<Child> children = new ArrayList<>() {
                {
                    add(new Child("A", (int) (Math.random() * 17) + 1));
                    add(new Child("B", (int) (Math.random() * 17) + 1));
                }
            };

            Customer customer1 = customer1 = new Customer("199010100001", "George", "Lina", children);
            Customer customer2 = customer2 = new Customer("199010100002", "Peter", "Mina", null);
            Customer customer3 = customer3 = new Customer("199010100003", "Michael", null, null);
            customerService.save(customer1);
            customerService.save(customer2);
            customerService.save(customer3);

            System.out.println(customerService.findCustomerBySocialSecurityNumber(customer1.getSocialSecurityNumber()));
            System.out.println(customerService.findCustomerBySocialSecurityNumber(customer2.getSocialSecurityNumber()));
            System.out.println(customerService.findCustomerBySocialSecurityNumber(customer3.getSocialSecurityNumber()));

            System.out.println(customer1);
            System.out.println(customerService.findOldestChildBySocialSecurityNumber(customer1.getSocialSecurityNumber()));
            System.out.println(customerService.findOldestChildBySocialSecurityNumber(customer2.getSocialSecurityNumber()));
            System.out.println(customerService.findOldestChildBySocialSecurityNumber(customer3.getSocialSecurityNumber()));

        } catch (Exception e) {
            System.out.println(e);
        }


        try {
            System.out.println(customerService.findCustomerBySocialSecurityNumber("199010100004"));
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            System.out.println(customerService.findOldestChildBySocialSecurityNumber("199010100004"));
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
