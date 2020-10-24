package com.thoughtworks.springbootemployee.controller;

import com.thoughtworks.springbootemployee.models.*;
import com.thoughtworks.springbootemployee.services.CompanyService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/companies")
public class CompanyController {
    private final CompanyService companyService;
    private final CompanyMapper companyMapper;
    private final EmployeeMapper employeeMapper;

    public CompanyController(CompanyService companyService, CompanyMapper companyMapper, EmployeeMapper employeeMapper) {
        this.companyService = companyService;
        this.companyMapper = companyMapper;
        this.employeeMapper = employeeMapper;
    }

    @GetMapping()
    public List<CompanyResponse> getAllCompanies() {
        List<Company> companies = companyService.getAll();
        return companies.stream().map(companyMapper::toResponse).collect(Collectors.toList());
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Company create(@RequestBody Company company){
        return companyService.createCompany(company);
    }

    @GetMapping("/{companyId}")
    public CompanyResponse getCompany(@PathVariable int companyId){
        Company company = companyService.findCompany(companyId);
        return companyMapper.toResponse(company);
    }

    @GetMapping("/{companyId}/employees")
    public List<EmployeeResponse> getEmployeesByCompanyID(@PathVariable int companyId){
        List<Employee> employees = companyService.findEmployeeByCompanyId(companyId);
        return employees.stream().map(employeeMapper::toResponse).collect(Collectors.toList());
    }

    @GetMapping(params = {"page","pageSize"})
    public List<CompanyResponse> getPagedCompanies(int page, int pageSize){
        List<Company> companies = companyService.getCompanyByPage(page, pageSize);
        return companies.stream().map(companyMapper::toResponse).collect(Collectors.toList());
    }

    @PutMapping("/{companyId}")
    public Company updateCompany(@PathVariable int companyId, @RequestBody Company newCompany){
        return companyService.updateCompany(companyId, newCompany);
    }

    @DeleteMapping("/{companyId}")
    public void deleteEmployee(@PathVariable int companyId){
        companyService.deleteEmployees(companyId);
    }
}
