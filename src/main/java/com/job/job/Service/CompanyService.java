package com.job.job.Service;

import com.job.job.Entities.Company;

import java.util.List;

public interface CompanyService {
    List<Company> getAllCompanies();
    boolean updateCompany(Long id , Company updatedCompany);
    void createCompany(Company company);
    void deleteCompany(Long id);
}
