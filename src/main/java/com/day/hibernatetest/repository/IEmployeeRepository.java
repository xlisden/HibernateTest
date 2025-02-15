
package com.day.hibernatetest.repository;

import com.day.hibernatetest.entity.Employee;
import java.util.List;
import javax.persistence.EntityManager;


public interface IEmployeeRepository {

    public void addEmployee(Employee employee);
    public void updateEmployee(Employee employee);
    public void deleteEmployee(Employee employee);
    public List<Employee> getAllEmployees();
    public Employee getByIdEmployee(int id);
    
}
