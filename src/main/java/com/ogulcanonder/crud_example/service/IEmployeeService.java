package com.ogulcanonder.crud_example.service;

import com.ogulcanonder.crud_example.dto.DtoEmployee;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IEmployeeService {
    public DtoEmployee saveEmployee(DtoEmployee dtoEmployee);
    public List<DtoEmployee> getAllEmployee();
    public DtoEmployee findByEmployee(Long id);
    public DtoEmployee updateEmployee(DtoEmployee dtoEmployee, Long id);
    public String deleteEmployee(Long id);
}
