package com.example.placementmanagementsystem.repository;

import com.example.placementmanagementsystem.entity.Drive;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DriveRepository extends JpaRepository<Drive, Integer> {

    // JOIN Drive with Company

    @Query("""
        SELECT d
        FROM Drive d
        JOIN d.company c
        WHERE c.companyId = :companyId
        """)
    List<Drive> findDrivesByCompany(
            @Param("companyId") int companyId);


    // JOIN using company name

    @Query("""
        SELECT d
        FROM Drive d
        JOIN d.company c
        WHERE c.companyName = :companyName
        """)
    List<Drive> findDrivesByCompanyName(
            @Param("companyName") String companyName);
}
