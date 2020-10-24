package com.thoughtworks.springbootemployee.models;

import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {

    public EmployeeResponse toResponse(Employee employee){
        EmployeeResponse response = new EmployeeResponse();

        response.setCompanyId(employee.getCompanyId());
        response.setAge(employee.getAge());
        response.setGender(employee.getGender());
        response.setName(employee.getName());
        response.setSalary(employee.getSalary());
        response.setEmployeeId(employee.getEmployeeId());

        return response;
    }

    public Employee toEntity(EmployeeRequest employeeRequest){
        Employee employee = new Employee();

        employee.setAge(employeeRequest.getAge());
        employee.setGender(employeeRequest.getGender());
        employee.setName(employeeRequest.getName());
        employee.setSalary(employeeRequest.getSalary());
        employee.setCompanyId(employeeRequest.getCompanyId());

        return employee;
    }
}
