package com.day.hibernatetest;

import com.day.hibernatetest.entity.Employee;
import com.day.hibernatetest.repository.IEmployeeRepository;
import com.day.hibernatetest.repository.impl.EmployeeRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Daye
 */
public class HibernateTest {

    public static void main(String[] args) {
        IEmployeeRepository employeeRepository = new EmployeeRepository();
        Scanner sc = new Scanner(System.in);
        List<Employee> employees = new ArrayList<>();
        Employee employee = new Employee();
        int id = 0;

        System.out.println("******** INSERTANDO EMPELADOS *********");
        for (int i = 1; i <= 10; i++) {
            Employee e = new Employee("name" + i, "department" + i);
            employeeRepository.addEmployee(e);
        }

        employees = employeeRepository.getAllEmployees();
        System.out.println("******** MOSTRANDO EMPELADOS *********");
        for (Employee e : employees) {
            System.out.println(e.toString());
        }

        System.out.println("******** BUSCAR EMPELADO *********");
        id = sc.nextInt();
        employee = employeeRepository.getByIdEmployee(id);
        System.out.println(employee.toString());

        System.out.println("******** BORRAR EMPELADO *********");
        id = sc.nextInt();
        employee = employeeRepository.getByIdEmployee(id);
        employeeRepository.deleteEmployee(employee);
        System.out.println(employee.toString());

        employees = employeeRepository.getAllEmployees();
        System.out.println("******** MOSTRANDO EMPELADOS *********");
        for (Employee e : employees) {
            System.out.println(e.toString());
        }

        System.out.println("**************************************");

    }
}
