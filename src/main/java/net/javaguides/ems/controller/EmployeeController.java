package net.javaguides.ems.controller;

import lombok.AllArgsConstructor;
import net.javaguides.ems.dto.EmployeeRequestDto;
import net.javaguides.ems.dto.EmployeeResponseDto;
import net.javaguides.ems.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {


    private EmployeeService employeeService;

    // Build add Employee Rest API
    @PostMapping
    public ResponseEntity<EmployeeResponseDto> createEmployee(@RequestBody EmployeeRequestDto employeeDto){
        try {
            EmployeeResponseDto savedEmployee = employeeService.createEmployee(employeeDto);
            return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
        }catch (Exception e){
            System.out.println("Exception Occurred "+ e);
            return new ResponseEntity<>(new EmployeeResponseDto(), HttpStatus.BAD_REQUEST);
        }

    }
    // Build Get Employee RestApi
    @GetMapping("{id}")
    public ResponseEntity<EmployeeResponseDto> getEmployeeById(@PathVariable("id") long employeeId){
       EmployeeResponseDto employeeDto = employeeService.getEmployeeById(employeeId);
       return ResponseEntity.ok(employeeDto);
    }
    //Build Get All employees Restapi
    @GetMapping
    public ResponseEntity<List<EmployeeResponseDto>> getAllEmployees(){
       List<EmployeeResponseDto> employees = employeeService.getAllEmployees();
       return ResponseEntity.ok(employees);
    }
    //Build Update Employee RestApi
    @PutMapping("{id}")
    public ResponseEntity<EmployeeResponseDto> updateEmployee(@PathVariable("id") Long employeeId ,@RequestBody EmployeeRequestDto updatedEmployee){

       EmployeeResponseDto employeeDto = employeeService.updateEmployee(employeeId,updatedEmployee);
       return ResponseEntity.ok(employeeDto);

    }

}
