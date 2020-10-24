package com.thoughtworks.springbootemployee.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class EmployeeRequest {
    private String name;
    private int age;
    private String gender;
    private int salary;
    private int companyId;

    public EmployeeRequest(){}

    public EmployeeRequest(String name, int age, String gender, int salary, int companyId) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.salary = salary;
        this.companyId = companyId;
    }

//    public EmployeeRequest(int employeeId, String name, int age, String gender, int salary) {
//        this.employeeId = employeeId;
//        this.name = name;
//        this.age = age;
//        this.gender = gender;
//        this.salary = salary;
//    }

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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }
}
