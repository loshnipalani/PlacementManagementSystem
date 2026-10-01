package com.example.placementmanagementsystem.repository;

import com.example.placementmanagementsystem.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    @Query("SELECT s FROM Student s WHERE s.department = :department")
    List<Student> findStudentsByDepartment(
            @Param("department") String department);

    @Query("SELECT s FROM Student s WHERE s.cgpa >= :cgpa")
    List<Student> findStudentsByMinimumCgpa(
            @Param("cgpa") double cgpa);

    @Query("SELECT s FROM Student s WHERE s.placementStatus = :status")
    List<Student> findStudentsByPlacementStatus(
            @Param("status") String status);
}
