package com.example.placementmanagementsystem.service;

import com.example.placementmanagementsystem.entity.Drive;
import com.example.placementmanagementsystem.repository.DriveRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriveService {

    private final DriveRepository repository;

    public DriveService(DriveRepository repository) {
        this.repository = repository;
    }

    public List<Drive> getAllDrives() {
        return repository.findAll();
    }

    public Drive getDriveById(int id) {
        return repository.findById(id).orElse(null);
    }

    public Drive addDrive(Drive drive) {
        return repository.save(drive);
    }

    public Drive updateDrive(Drive drive) {
        return repository.save(drive);
    }

    public void deleteDrive(int id) {
        repository.deleteById(id);
    }

    // JOIN with Company
    public List<Drive> getDrivesByCompany(int companyId) {
        return repository.findDrivesByCompany(companyId);
    }

    public List<Drive> getDrivesByCompanyName(String companyName) {
        return repository.findDrivesByCompanyName(companyName);
    }
}
