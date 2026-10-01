package com.example.placementmanagementsystem.controller;

import com.example.placementmanagementsystem.entity.Student;
import com.example.placementmanagementsystem.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@CrossOrigin
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    // GET all students
    @GetMapping
    public List<Student> getAllStudents() {
        return service.getAllStudents();
    }

    // GET student by ID
    @GetMapping("/{id}")
    public Student getStudent(@PathVariable int id) {
        return service.getStudentById(id);
    }

    // ADD student
    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return service.addStudent(student);
    }

    // UPDATE student
    @PutMapping
    public Student updateStudent(@RequestBody Student student) {
        return service.updateStudent(student);
    }

    // DELETE student
    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable int id) {
        service.deleteStudent(id);
        return "Student deleted successfully";
    }

    // Search by department
    @GetMapping("/department/{department}")
    public List<Student> getByDepartment(
            @PathVariable String department) {

        return service.getStudentsByDepartment(department);
    }

    // Search by CGPA
    @GetMapping("/cgpa/{cgpa}")
    public List<Student> getByCgpa(
            @PathVariable double cgpa) {

        return service.getStudentsByCgpa(cgpa);
    }

    // Search by placement status
    @GetMapping("/status/{status}")
    public List<Student> getByPlacementStatus(
            @PathVariable String status) {

        return service.getStudentsByPlacementStatus(status);
    }
}