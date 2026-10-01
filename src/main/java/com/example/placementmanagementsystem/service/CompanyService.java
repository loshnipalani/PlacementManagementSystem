package com.example.placementmanagementsystem.service;

import com.example.placementmanagementsystem.entity.Company;
import com.example.placementmanagementsystem.repository.CompanyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {

    private final CompanyRepository repository;

    public CompanyService(CompanyRepository repository) {
        this.repository = repository;
    }

    public List<Company> getAllCompanies() {
        return repository.findAll();
    }

    public Company getCompanyById(int id) {
        return repository.findById(id).orElse(null);
    }

    public Company addCompany(Company company) {
        return repository.save(company);
    }

    public Company updateCompany(Company company) {
        return repository.save(company);
    }

    public void deleteCompany(int id) {
        repository.deleteById(id);
    }

    // Subquery result
    public List<Company> getCompaniesAboveAverageApplications() {
        return repository.findCompaniesAboveAverageApplications();
    }

    // Function result
    public Integer countApplicationsByCompany(int companyId) {
        return repository.countApplicationsByCompany(companyId);
    }
}