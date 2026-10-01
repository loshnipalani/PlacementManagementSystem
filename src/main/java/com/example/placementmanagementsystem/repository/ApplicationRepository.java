package com.example.placementmanagementsystem.repository;

import com.example.placementmanagementsystem.entity.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ApplicationRepository
        extends JpaRepository<Application, Integer> {


    // JOIN
    // Display student applications with company information

    @Query("""
        SELECT s.name,
               s.email,
               c.companyName,
               d.jobRole,
               a.applicationDate,
               a.status
        FROM Application a
        JOIN a.student s
        JOIN a.drive d
        JOIN d.company c
        """)
    List<Object[]> getStudentApplicationsWithCompany();


    // Find applications of a particular student

    @Query("""
        SELECT a
        FROM Application a
        JOIN a.student s
        WHERE s.studentId = :studentId
        """)
    List<Application> findApplicationsByStudent(
            @Param("studentId") int studentId);


    // Find applications received by a particular company

    @Query("""
        SELECT a
        FROM Application a
        JOIN a.drive d
        JOIN d.company c
        WHERE c.companyId = :companyId
        """)
    List<Application> findApplicationsByCompany(
            @Param("companyId") int companyId);


    // PROCEDURE
    // Register student for placement drive

    @Procedure(procedureName = "register_student_for_drive")
    void registerStudentForDrive(
            @Param("p_student_id") int studentId,
            @Param("p_drive_id") int driveId);
}
