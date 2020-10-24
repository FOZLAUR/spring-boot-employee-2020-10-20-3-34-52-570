package com.thoughtworks.springbootemployee.dto;

import com.thoughtworks.springbootemployee.models.Employee;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class CompanyResponse {
    private int companyId;
    private String companyName;
    private List<Employee> employees=new ArrayList<>();

    public CompanyResponse(int companyId, String companyName, List<Employee> employees) {
        this.companyId = companyId;
        this.companyName = companyName;
        this.employees = employees;
    }

    public CompanyResponse() { }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
