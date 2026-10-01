package com.example.placementmanagementsystem.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "drives")
public class Drive {

    @Id
    private int driveId;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    private LocalDate driveDate;
    private double eligibilityCgpa;
    private String jobRole;

    public Drive() {
    }

    public Drive(int driveId, Company company, LocalDate driveDate,
                 double eligibilityCgpa, String jobRole) {
        this.driveId = driveId;
        this.company = company;
        this.driveDate = driveDate;
        this.eligibilityCgpa = eligibilityCgpa;
        this.jobRole = jobRole;
    }

    public int getDriveId() {
        return driveId;
    }

    public void setDriveId(int driveId) {
        this.driveId = driveId;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public LocalDate getDriveDate() {
        return driveDate;
    }

    public void setDriveDate(LocalDate driveDate) {
        this.driveDate = driveDate;
    }

    public double getEligibilityCgpa() {
        return eligibilityCgpa;
    }

    public void setEligibilityCgpa(double eligibilityCgpa) {
        this.eligibilityCgpa = eligibilityCgpa;
    }

    public String getJobRole() {
        return jobRole;
    }

    public void setJobRole(String jobRole) {
        this.jobRole = jobRole;
    }
}
