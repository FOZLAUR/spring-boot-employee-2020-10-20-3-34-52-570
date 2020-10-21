package com.thoughtworks.springbootemployee.repositories;

import com.thoughtworks.springbootemployee.models.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeRepository {
    private final List<Employee> employeeList = new ArrayList<>();

    public List<Employee> findAll() {
        return employeeList;
    }

    public Employee addEmployee(Employee employee) {
        employeeList.add(employee);
        return employee;
    }

    public void updateEmployee(int employeeID, Employee updatedEmployee) {
        employeeList.stream()
                .filter(employee -> employee.getEmployeeID() == employeeID)
                .findFirst()
                .ifPresent(employee -> {
                    employeeList.remove(employee);
                    employeeList.add(updatedEmployee);
                });
    }

    public void deleteEmployee(int employeeID) {
        employeeList.stream()
                .filter(employee -> employee.getEmployeeID() == employeeID)
                .findFirst()
                .ifPresent(employeeList::remove);
    }

    public Employee findEmployee(int employeeID) {
        return null;
    }
}
