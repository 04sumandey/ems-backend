package net.javaguides.ems.mapper;

import net.javaguides.ems.dto.EmployeeRequestDto;
import net.javaguides.ems.dto.EmployeeResponseDto;
import net.javaguides.ems.entity.Employee;

public class EmployeeMapper {
    public static EmployeeResponseDto mapToEmployeeDto(Employee employee){
        return new EmployeeResponseDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail()
        );
    }

    public static Employee mapToEmployee(EmployeeRequestDto employeeDto){
        return new Employee(
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail()
        );
    }
}
