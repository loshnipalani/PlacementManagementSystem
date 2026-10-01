package com.example.placementmanagementsystem.controller;

import com.example.placementmanagementsystem.entity.Drive;
import com.example.placementmanagementsystem.service.DriveService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/drives")
@CrossOrigin
public class DriveController {

    private final DriveService service;

    public DriveController(DriveService service) {
        this.service = service;
    }

    // GET all drives
    @GetMapping
    public List<Drive> getAllDrives() {
        return service.getAllDrives();
    }

    // GET drive by ID
    @GetMapping("/{id}")
    public Drive getDrive(@PathVariable int id) {
        return service.getDriveById(id);
    }

    // ADD drive
    @PostMapping
    public Drive addDrive(@RequestBody Drive drive) {
        return service.addDrive(drive);
    }

    // UPDATE drive
    @PutMapping
    public Drive updateDrive(@RequestBody Drive drive) {
        return service.updateDrive(drive);
    }

    // DELETE drive
    @DeleteMapping("/{id}")
    public String deleteDrive(@PathVariable int id) {
        service.deleteDrive(id);
        return "Drive deleted successfully";
    }

    // JOIN with Company
    @GetMapping("/company/{companyId}")
    public List<Drive> getDrivesByCompany(
            @PathVariable int companyId) {

        return service.getDrivesByCompany(companyId);
    }

    // JOIN with Company using company name
    @GetMapping("/company-name/{companyName}")
    public List<Drive> getDrivesByCompanyName(
            @PathVariable String companyName) {

        return service.getDrivesByCompanyName(companyName);
    }
}