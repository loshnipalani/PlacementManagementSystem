package com.example.placementmanagementsystem.repository;

import com.example.placementmanagementsystem.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CompanyRepository extends JpaRepository<Company, Integer> {

    // JOIN + SUBQUERY
    // Find companies receiving applications above average

    @Query(value = """
        SELECT c.company_id,
               c.company_name,
               c.location,
               c.job_role,
               c.package_amount
        FROM companies c
        JOIN drives d
            ON c.company_id = d.company_id
        JOIN applications a
            ON d.drive_id = a.drive_id
        GROUP BY c.company_id,
                 c.company_name,
                 c.location,
                 c.job_role,
                 c.package_amount
        HAVING COUNT(a.application_id) >
        (
            SELECT AVG(application_count)
            FROM
            (
                SELECT COUNT(a2.application_id) AS application_count
                FROM applications a2
                JOIN drives d2
                    ON a2.drive_id = d2.drive_id
                GROUP BY d2.company_id
            ) AS average_table
        )
        """, nativeQuery = true)
    List<Company> findCompaniesAboveAverageApplications();


    // FUNCTION
    // Count applications received by a company

    @Query(value =
            "SELECT count_applications_by_company(:companyId)",
            nativeQuery = true)
    Integer countApplicationsByCompany(
            @Param("companyId") int companyId);
}
