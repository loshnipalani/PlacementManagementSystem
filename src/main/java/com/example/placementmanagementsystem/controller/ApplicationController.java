package com.example.placementmanagementsystem.controller;

import com.example.placementmanagementsystem.entity.Application;
import com.example.placementmanagementsystem.service.ApplicationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/applications")
@CrossOrigin
public class ApplicationController {

    private final ApplicationService service;

    public ApplicationController(ApplicationService service) {
        this.service = service;
    }

    // GET all applications
    @GetMapping
    public List<Application> getAllApplications() {
        return service.getAllApplications();
    }

    // GET application by ID
    @GetMapping("/{id}")
    public Application getApplication(@PathVariable int id) {
        return service.getApplicationById(id);
    }

    // ADD application
    @PostMapping
    public Application addApplication(
            @RequestBody Application application) {

        return service.addApplication(application);
    }

    // UPDATE application
    @PutMapping
    public Application updateApplication(
            @RequestBody Application application) {

        return service.updateApplication(application);
    }

    // DELETE application
    @DeleteMapping("/{id}")
    public String deleteApplication(@PathVariable int id) {

        service.deleteApplication(id);

        return "Application deleted successfully";
    }

    // JOIN
    // Student applications with company information
    @GetMapping("/student-company")
    public List<Object[]> getStudentApplicationsWithCompany() {

        return service.getStudentApplicationsWithCompany();
    }

    // Applications submitted by a student
    @GetMapping("/student/{studentId}")
    public List<Application> getByStudent(
            @PathVariable int studentId) {

        return service.getApplicationsByStudent(studentId);
    }

    // Applications received by a company
    @GetMapping("/company/{companyId}")
    public List<Application> getByCompany(
            @PathVariable int companyId) {

        return service.getApplicationsByCompany(companyId);
    }

    // PROCEDURE
    // Register student for placement drive
    @PostMapping("/register")
    public String registerStudentForDrive(
            @RequestParam int studentId,
            @RequestParam int driveId) {

        service.registerStudentForDrive(studentId, driveId);

        return "Student registered for placement drive successfully";
    }
}
