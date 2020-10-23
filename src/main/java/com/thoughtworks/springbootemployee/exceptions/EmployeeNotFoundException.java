package com.thoughtworks.springbootemployee.exceptions;

public class EmployeeNotFoundException extends RuntimeException{
    public EmployeeNotFoundException(int employeeId) {
        super("Employee "+employeeId+" not found.");
    }
}
