package com.ogulcanonder.crud_example.mapper;

import com.ogulcanonder.crud_example.dto.DtoEmployee;
import com.ogulcanonder.crud_example.entities.Employee;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    DtoEmployee toDto(Employee employee); // Employee → DTO
    Employee toEntity(DtoEmployee dtoEmployee); // DTO → Employee
    List<DtoEmployee> toDtoList(List<Employee>employeeList);
    List<Employee> toEntityList(List<DtoEmployee>dtoEmployeeList);
}
