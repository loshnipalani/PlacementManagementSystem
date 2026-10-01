package com.example.placementmanagementsystem.service;

import com.example.placementmanagementsystem.entity.Application;
import com.example.placementmanagementsystem.repository.ApplicationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationService {

    private final ApplicationRepository repository;

    public ApplicationService(ApplicationRepository repository) {
        this.repository = repository;
    }

    public List<Application> getAllApplications() {
        return repository.findAll();
    }

    public Application getApplicationById(int id) {
        return repository.findById(id).orElse(null);
    }

    public Application addApplication(Application application) {
        return repository.save(application);
    }

    public Application updateApplication(Application application) {
        return repository.save(application);
    }

    public void deleteApplication(int id) {
        repository.deleteById(id);
    }

    // JOIN
    public List<Object[]> getStudentApplicationsWithCompany() {
        return repository.getStudentApplicationsWithCompany();
    }

    // Student applications
    public List<Application> getApplicationsByStudent(int studentId) {
        return repository.findApplicationsByStudent(studentId);
    }

    // Company applications
    public List<Application> getApplicationsByCompany(int companyId) {
        return repository.findApplicationsByCompany(companyId);
    }

    // PROCEDURE
    public void registerStudentForDrive(int studentId, int driveId) {
        repository.registerStudentForDrive(studentId, driveId);
    }
}
