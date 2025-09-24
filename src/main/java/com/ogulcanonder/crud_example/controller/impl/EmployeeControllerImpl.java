package com.ogulcanonder.crud_example.controller.impl;

import com.ogulcanonder.crud_example.controller.IEmployeeController;
import com.ogulcanonder.crud_example.dto.DtoEmployee;
import com.ogulcanonder.crud_example.service.IEmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.function.Consumer;

@RestController
@RequestMapping("/rest/api/employee")
@RequiredArgsConstructor

public class EmployeeControllerImpl implements IEmployeeController {

    private final IEmployeeService employeeService;

    @PostMapping("/save")
    @Override
    public ResponseEntity<DtoEmployee> saveEmployee(@Valid  @RequestBody DtoEmployee dtoEmployee) {
        DtoEmployee saved=employeeService.saveEmployee(dtoEmployee);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @GetMapping("/list")
    @Override
    public ResponseEntity<List<DtoEmployee>> getAllEmployee() {
        List<DtoEmployee> employeeList=employeeService.getAllEmployee();
        return ResponseEntity.status(HttpStatus.OK).body(employeeList);
    }

    @GetMapping("{id}")
    @Override
    public ResponseEntity<DtoEmployee> findByEmployee(@PathVariable(name = "id") Long id) {
        DtoEmployee employee=employeeService.findByEmployee(id);
        return ResponseEntity.status(HttpStatus.OK).body(employee);
    }

    @PutMapping("/update/{id}")
    @Override
    public ResponseEntity<DtoEmployee> updateEmployee(@RequestBody DtoEmployee dtoEmployee, @PathVariable(name = "id") Long id) {
       DtoEmployee employee=employeeService.updateEmployee(dtoEmployee,id);
        return ResponseEntity.status(HttpStatus.OK).body(employee);
    }

    @DeleteMapping("/delete/{id}")
    @Override
    public ResponseEntity<String> deleteEmployee(@PathVariable(name = "id") Long id) {
        String result= employeeService.deleteEmployee(id);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

}
