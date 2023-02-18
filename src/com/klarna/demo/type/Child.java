package com.klarna.demo.type;

public class Child {
    private String name;
    private Integer age;

    public Child() {
    }

    public Child(String name, Integer age) throws Exception {
        if (name == null || name.isEmpty()) {
            throw new Exception("Child name");
        }
        this.name = name;

        if (age == null || age < 1) {
            throw new Exception("Child age");
        }
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Child{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
