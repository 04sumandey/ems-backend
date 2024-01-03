package net.javaguides.ems.service;

import net.javaguides.ems.dto.EmployeeRequestDto;
import net.javaguides.ems.dto.EmployeeResponseDto;

import java.util.List;

public interface EmployeeService {
    EmployeeResponseDto createEmployee(EmployeeRequestDto employeeDto);

    EmployeeResponseDto getEmployeeById(long employee);
    List<EmployeeResponseDto> getAllEmployees();

    EmployeeResponseDto updateEmployee(Long employeeId,EmployeeRequestDto updatedEmployee);
}
