package com.example.pengadaanrsudsamrat.users;

import com.example.pengadaanrsudsamrat.users.DTO.CreateEmployeeRequestDTO;
import com.example.pengadaanrsudsamrat.users.DTO.CreateEmployeeResponseDTO;
import com.example.pengadaanrsudsamrat.users.DTO.EmployeeRequestDTO;
import com.example.pengadaanrsudsamrat.users.DTO.EmployeeResponseDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public EmployeeResponseDTO login(EmployeeRequestDTO employeeRequestDTO) {
        Optional<EmployeeModel> employeeModelOptional = employeeRepository.findByUsername(employeeRequestDTO.getUsername());
        if (employeeModelOptional.isPresent()) {
            EmployeeModel employeeModel = employeeModelOptional.get();
            if (employeeRequestDTO.getPassword().equals(employeeModel.getPassword())) {
                return modelMapper.map(employeeModel, EmployeeResponseDTO.class);
            }
        }
        return null;
    }

    @Override
    public CreateEmployeeResponseDTO createEmployee(CreateEmployeeRequestDTO createEmployeeRequestDTO) {
        EmployeeModel employeeModel = modelMapper.map(createEmployeeRequestDTO, EmployeeModel.class);
        EmployeeModel savedEmployee = employeeRepository.save(employeeModel);
        return modelMapper.map(savedEmployee, CreateEmployeeResponseDTO.class);
    }
}
