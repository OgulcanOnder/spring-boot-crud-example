package com.ogulcanonder.crud_example.service.impl;

import com.ogulcanonder.crud_example.dto.DtoEmployee;
import com.ogulcanonder.crud_example.entities.Employee;
import com.ogulcanonder.crud_example.mapper.EmployeeMapper;
import com.ogulcanonder.crud_example.repository.EmployeeRepository;
import com.ogulcanonder.crud_example.service.IEmployeeService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Consumer;

@RequiredArgsConstructor
@Service
public class EmployeeServiceImpl implements IEmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;


    @Override
    public DtoEmployee saveEmployee(DtoEmployee dtoEmployee) {
        if (employeeRepository.existsByEmail(dtoEmployee.getEmail())){
            throw new RuntimeException("This Email Not Unique");
        }
        Employee employee=employeeMapper.toEntity(dtoEmployee);
        Employee savedEmployee=employeeRepository.save(employee);
        return employeeMapper.toDto(savedEmployee);
    }

    @Override
    public List<DtoEmployee> getAllEmployee() {
        List<Employee> employeeList=employeeRepository.findAll();
        if (employeeList==null){
            throw new RuntimeException("Employee Not Found.");
        }
        return employeeMapper.toDtoList(employeeList);
    }

    @Override
    public DtoEmployee findByEmployee(Long id) {
        Employee employee=employeeRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("This Employee Not Found."));
        return employeeMapper.toDto(employee);
    }

    @Override
    public DtoEmployee updateEmployee(DtoEmployee dtoEmployee, Long id) {
        Employee employee=employeeRepository.findById(id)
                .orElseThrow(()->new RuntimeException("This Employee Not Found"));
        updateIfNotEmpty(dtoEmployee.getName(), employee::setName);
        updateIfNotEmpty(dtoEmployee.getSurname(),employee::setSurname);
        updateIfNotEmpty(dtoEmployee.getEmail(),employee::setEmail);
        updateIfNotEmpty(dtoEmployee.getPhoneNumber(),employee::setPhoneNumber);
        Employee saveEmployee=employeeRepository.save(employee);
        return employeeMapper.toDto(saveEmployee);
    }

    @Override
    public String deleteEmployee(Long id) {
        Employee employee=employeeRepository.findById(id)
                .orElseThrow(()->new RuntimeException("This Employee Not Found"));
        employeeRepository.delete(employee);

        return "Employee with ID " +employee.getId()+ " has been deleted successfully.";
    }

    private void updateIfNotEmpty(String newValue, Consumer<String> setter){
        if (newValue!=null && !newValue.trim().isEmpty()){
            setter.accept(newValue.trim());
        }
    }
}
