package com.example.pengadaanrsudsamrat.users;

import com.example.pengadaanrsudsamrat.users.DTO.CreateEmployeeRequestDTO;
import com.example.pengadaanrsudsamrat.users.DTO.CreateEmployeeResponseDTO;
import com.example.pengadaanrsudsamrat.users.DTO.EmployeeRequestDTO;
import com.example.pengadaanrsudsamrat.users.DTO.EmployeeResponseDTO;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;


    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;

    }

    @PostMapping("/login")
    public ResponseEntity<EmployeeResponseDTO> login(@RequestBody EmployeeRequestDTO employeeRequestDTO) {
        EmployeeResponseDTO employeeResponseDTO = employeeService.login(employeeRequestDTO);
        if (employeeResponseDTO != null) {
            return ResponseEntity.ok(employeeResponseDTO);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @PostMapping
    public ResponseEntity<CreateEmployeeResponseDTO> createEmployee(@RequestBody CreateEmployeeRequestDTO createEmployeeRequestDTO) {
        CreateEmployeeResponseDTO createdEmployee = employeeService.createEmployee(createEmployeeRequestDTO);
        return new ResponseEntity<>(createdEmployee, HttpStatus.CREATED);
    }

}

