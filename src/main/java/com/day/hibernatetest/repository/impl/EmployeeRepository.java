package com.day.hibernatetest.repository.impl;

import com.day.hibernatetest.config.HibernateConfig;
import com.day.hibernatetest.entity.Employee;
import java.util.List;
import javax.persistence.EntityManager;
import com.day.hibernatetest.repository.IEmployeeRepository;

public class EmployeeRepository implements IEmployeeRepository {

    private HibernateConfig hc = new HibernateConfig();
    private EntityManager em;

    @Override
    public void addEmployee(Employee employee) {
        em = hc.getEntityManager();
        em.getTransaction().begin();
        em.persist(employee);
        em.getTransaction().commit();
        hc.closeConnection();
    }

    @Override
    public void updateEmployee(Employee employee) {
        em = hc.getEntityManager();
        Employee e = em.find(Employee.class, employee.getId());
        em.getTransaction().begin();
        e.setDepartment(employee.getDepartment());
        e.setName(employee.getName());
        em.getTransaction().commit();
        hc.closeConnection();
    }

    @Override
    public void deleteEmployee(Employee employee) {
        em = hc.getEntityManager();
        Employee e = em.find(Employee.class, employee.getId());
        em.getTransaction().begin();
        em.remove(e);
        em.getTransaction().commit();
        hc.closeConnection();
    }

    @Override
    public List<Employee> getAllEmployees() {
        em = hc.getEntityManager();
        List<Employee> employees = em.createQuery("SELECT e FROM Employee e", Employee.class).getResultList();
        hc.closeConnection();
        return employees;
    }

    @Override
    public Employee getByIdEmployee(int id) {
        em = hc.getEntityManager();
        Employee e = em.find(Employee.class, id);
        hc.closeConnection();
        return e;
    }

}
