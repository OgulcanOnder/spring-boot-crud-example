package com.ogulcanonder.crud_example.controller;

import com.ogulcanonder.crud_example.dto.DtoEmployee;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IEmployeeController {
    public ResponseEntity<DtoEmployee> saveEmployee(DtoEmployee dtoEmployee);
    public ResponseEntity<List<DtoEmployee>> getAllEmployee();
    public ResponseEntity<DtoEmployee> findByEmployee(Long id);
    public ResponseEntity<DtoEmployee> updateEmployee(DtoEmployee dtoEmployee, Long id);
    public ResponseEntity<String> deleteEmployee(Long id);

}
