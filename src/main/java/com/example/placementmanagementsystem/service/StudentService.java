package com.example.placementmanagementsystem.service;

import com.example.placementmanagementsystem.entity.Student;
import com.example.placementmanagementsystem.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    public Student getStudentById(int id) {
        return repository.findById(id).orElse(null);
    }

    public Student addStudent(Student student) {
        return repository.save(student);
    }

    public Student updateStudent(Student student) {
        return repository.save(student);
    }

    public void deleteStudent(int id) {
        repository.deleteById(id);
    }

    public List<Student> getStudentsByDepartment(String department) {
        return repository.findStudentsByDepartment(department);
    }

    public List<Student> getStudentsByCgpa(double cgpa) {
        return repository.findStudentsByMinimumCgpa(cgpa);
    }

    public List<Student> getStudentsByPlacementStatus(String status) {
        return repository.findStudentsByPlacementStatus(status);
    }
}