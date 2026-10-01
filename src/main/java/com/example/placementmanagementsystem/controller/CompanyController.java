package com.example.placementmanagementsystem.controller;

import com.example.placementmanagementsystem.entity.Company;
import com.example.placementmanagementsystem.service.CompanyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/companies")
@CrossOrigin
public class CompanyController {

    private final CompanyService service;

    public CompanyController(CompanyService service) {
        this.service = service;
    }

    // GET all companies
    @GetMapping
    public List<Company> getAllCompanies() {
        return service.getAllCompanies();
    }

    // GET company by ID
    @GetMapping("/{id}")
    public Company getCompany(@PathVariable int id) {
        return service.getCompanyById(id);
    }

    // ADD company
    @PostMapping
    public Company addCompany(@RequestBody Company company) {
        return service.addCompany(company);
    }

    // UPDATE company
    @PutMapping
    public Company updateCompany(@RequestBody Company company) {
        return service.updateCompany(company);
    }

    // DELETE company
    @DeleteMapping("/{id}")
    public String deleteCompany(@PathVariable int id) {
        service.deleteCompany(id);
        return "Company deleted successfully";
    }

    // SUBQUERY
    // Companies receiving applications above average
    @GetMapping("/above-average")
    public List<Company> getAboveAverageCompanies() {
        return service.getCompaniesAboveAverageApplications();
    }

    // FUNCTION
    // Count applications for a company
    @GetMapping("/{id}/application-count")
    public Integer getApplicationCount(
            @PathVariable int id) {

        return service.countApplicationsByCompany(id);
    }
}