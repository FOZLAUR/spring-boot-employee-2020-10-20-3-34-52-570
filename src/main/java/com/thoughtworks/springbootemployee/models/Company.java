package com.thoughtworks.springbootemployee.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int companyId;
    private String companyName;
    @OneToMany(
            fetch = FetchType.EAGER
    )
    @JoinColumn(columnDefinition = "company_id")
    private List<Employee> employees=new ArrayList<>();

    public Company(String companyName) {
        this.companyName = companyName;
    }

//    public Company(String companyName, List<Employee> employees) {
//        this.companyName = companyName;
//        this.employees = employees;
//    }

    public Company() { }

    public int getCompanyId() {
        return companyId;
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
