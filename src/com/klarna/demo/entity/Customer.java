package com.klarna.demo.entity;

import com.klarna.demo.type.Child;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

public class Customer {
    private int id;
    private String socialSecurityNumber;
    private String name;
    private String spouseName;
    private List<Child> children;

    public Customer() {
    }

    public Customer(String socialSecurityNumber, String name, String spouseName, List<Child> children) throws Exception {

        if (socialSecurityNumber == null || socialSecurityNumber.length() != 12) {
            throw new Exception("socialSecurityNumber");
        }

        try {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd");
            String birthDate = socialSecurityNumber.substring(0, 8), backNumber = socialSecurityNumber.substring(8);
            LocalDate.parse(birthDate, dtf);
            Integer.parseInt(backNumber);
        } catch (DateTimeParseException | NumberFormatException e) {
            throw new Exception("socialSecurityNumber, " + e);
        }

        this.socialSecurityNumber = socialSecurityNumber;

        if (name == null || name.isEmpty()) {
            throw new Exception("customer name");
        }
        this.name = name;

        this.spouseName = spouseName;
        this.children = children;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public void setSocialSecurityNumber(String socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }

    public String getCustomerName() {
        return name;
    }

    public void setCustomerName(String name) {
        this.name = name;
    }

    public String getSpouseName() {
        return spouseName;
    }

    public void setSpouseName(String spouseName) {
        this.spouseName = spouseName;
    }

    public List<Child> getChildren() {
        return children;
    }

    public void setChildren(List<Child> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", socialSecurityNumber='" + socialSecurityNumber + '\'' +
                ", name='" + name + '\'' +
                ", spouseName='" + spouseName + '\'' +
                ", children=" + children +
                '}';
    }
}
