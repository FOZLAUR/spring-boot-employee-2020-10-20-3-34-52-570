package com.thoughtworks.springbootemployee.exceptions;

public class CompanyNotFoundException extends RuntimeException{
    public CompanyNotFoundException(int employeeId) {
        super("Company "+employeeId+" not found.");
    }
}
