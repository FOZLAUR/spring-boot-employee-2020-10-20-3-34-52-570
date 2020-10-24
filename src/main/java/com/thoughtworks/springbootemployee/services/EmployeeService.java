package com.thoughtworks.springbootemployee.services;

import com.thoughtworks.springbootemployee.exceptions.EmployeeNotFoundException;
import com.thoughtworks.springbootemployee.models.Employee;
import com.thoughtworks.springbootemployee.repositories.EmployeeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(int employeeID, Employee updatedEmployee) {
        Employee employee = findEmployee(employeeID);
        if(updatedEmployee.getName() != null){
            employee.setName(updatedEmployee.getName());
        }
        if(updatedEmployee.getAge() > 0){
            employee.setAge(updatedEmployee.getAge());
        }
        if(updatedEmployee.getGender() != null){
            employee.setGender(updatedEmployee.getGender());
        }
        if(updatedEmployee.getSalary() > 0){
            employee.setSalary(updatedEmployee.getSalary());
        }
        if(updatedEmployee.getCompanyId() > 0){
            employee.setCompanyId(updatedEmployee.getCompanyId());
        }
        employeeRepository.save(employee);
        return employee;
    }

    public void deleteEmployee(int employeeID) {
        //employeeRepository.findById(employeeID).orElseThrow(() -> new EmployeeNotFoundException(employeeID));
        employeeRepository.deleteById(employeeID);
    }

    public Employee findEmployee(int employeeID) {
        return employeeRepository.findById(employeeID).orElseThrow(() -> new EmployeeNotFoundException(employeeID));
    }

    public List<Employee> findEmployeesByGender(String gender) {
        return employeeRepository.findByGender(gender);
    }

    public List<Employee> getEmployeeByPage(int page, int pageSize) {
        Page<Employee> employees = employeeRepository.findAll(PageRequest.of(page, pageSize));
        return employees.toList();
    }
}
