package com.klarna.demo.type;

public class ChildData {
    private String parentSocialSecurityNumber;
    private Child child;

    public ChildData() {
    }

    public ChildData(String parentSocialSecurityNumber, Child child) {
        this.parentSocialSecurityNumber = parentSocialSecurityNumber;
        this.child = child;
    }

    public String getParentSocialSecurityNumber() {
        return parentSocialSecurityNumber;
    }

    public void setParentSocialSecurityNumber(String parentSocialSecurityNumber) {
        this.parentSocialSecurityNumber = parentSocialSecurityNumber;
    }

    public Child getChild() {
        return child;
    }

    public void setChild(Child child) {
        this.child = child;
    }

    @Override
    public String toString() {
        return "ChildData{" +
                "parentSocialSecurityNumber='" + parentSocialSecurityNumber + '\'' +
                ", child=" + child +
                '}';
    }
}
