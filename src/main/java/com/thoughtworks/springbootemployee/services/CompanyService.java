package com.thoughtworks.springbootemployee.services;

import com.thoughtworks.springbootemployee.models.Company;
import com.thoughtworks.springbootemployee.models.Employee;
import com.thoughtworks.springbootemployee.repositories.CompanyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {
    private final CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public List<Company> getAll() {
        return companyRepository.findAll();
    }

    public Company createCompany(Company expectedCompany) {
        return companyRepository.addCompany(expectedCompany);
    }

    public Company findCompany(int companyID) {
        return companyRepository.findCompany(companyID);
    }

    public List<Employee> findEmployeeByCompanyID(int companyID) {
        return companyRepository.findEmployeeByCompanyID(companyID);
    }
}
