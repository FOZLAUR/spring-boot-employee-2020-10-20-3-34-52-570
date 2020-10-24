package com.thoughtworks.springbootemployee.dto;

import com.thoughtworks.springbootemployee.models.Company;
import org.springframework.stereotype.Component;

@Component
public class CompanyMapper {

    public CompanyResponse toResponse(Company company){
        CompanyResponse response = new CompanyResponse();

        response.setCompanyId(company.getCompanyId());
        response.setCompanyName(company.getCompanyName());
        response.setEmployees(company.getEmployees());

        return response;
    }

    public Company toEntity(CompanyRequest companyRequest){
        Company company = new Company();

        company.setCompanyName(companyRequest.getCompanyName());

        return company;
    }
}
