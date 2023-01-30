package com.gltraining;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Demo2 {
    EntityManagerFactory emf;

    public static void main(String args[]) {
        Demo2 demo = new Demo2();
        demo.start();

    }

    public void start() {
        emf = Persistence.createEntityManagerFactory("empms");
        Employee employee1 = register("nikhil", 22, 90000);
        Employee employee2 = register("alfayeed", 23, 100000);
        System.out.println("employees registered are now in detached state");
        display(employee1);
        display(employee2);

        int id = employee1.getId();

        Employee found = findById(id);
        System.out.println("found employee by id=" + id);
        display(found);

        Employee updated = changeAge(id, 25);
        System.out.println("age updated");
        display(updated);


        emf.close();


    }


    public Employee findById(int id) {
        EntityManager em = emf.createEntityManager();
        Employee employee = em.find(Employee.class, id);
        return employee;
    }


    public Employee changeAge(int id, int newAge) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Employee employee = findById(id);
        employee.setAge(newAge);
        employee=em.merge(employee);
        transaction.commit();
        em.close();
        return employee;
    }

    public Employee register(String name, int age, double balance) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Employee employee = new Employee(name, age, balance);
        //em.persist(employee)
        employee=em.merge(employee);
        transaction.commit();
        em.close();
        return employee;
    }

    public void delete(int id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Employee employee = findById(id);
        em.remove(employee);
        transaction.commit();
        em.close();
    }

    void display(Employee employee) {
        System.out.println("id=" + employee.getId() + ",name=" + employee.getName() + ",age=" + employee.getAge() + ",salary=" + employee.getSalary());
    }
}
