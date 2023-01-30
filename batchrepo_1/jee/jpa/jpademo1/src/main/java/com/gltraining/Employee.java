package com.gltraining;

import javax.persistence.*;
import java.util.Objects;


@Table(name = "employees_data")
@Entity
public class Employee {
    @GeneratedValue
    @Id
    private Integer id;
    @Column(name="empname",nullable = false)
    private String name;
    private int age;
    private double salary;

    public Employee() {
    }

    public Employee( String name, int age, double salary) {
        this.age = age;
        this.name = name;
        this.salary = salary;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
