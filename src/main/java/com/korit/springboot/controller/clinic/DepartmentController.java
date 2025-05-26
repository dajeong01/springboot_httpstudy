package com.korit.springboot.controller.clinic;

import com.korit.springboot.domain.department.Department;
import com.korit.springboot.domain.department.DepartmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class DepartmentController {

    private DepartmentRepository departmentRepository;

    @PostMapping("/api/clinic/departments")
    public ResponseEntity<?> register(@RequestBody Department department) {
        departmentRepository.save(department);
        return ResponseEntity.ok(true);
    }
}
