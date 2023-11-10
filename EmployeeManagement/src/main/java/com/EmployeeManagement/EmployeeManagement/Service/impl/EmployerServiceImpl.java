package com.EmployeeManagement.EmployeeManagement.Service.impl;

import com.EmployeeManagement.EmployeeManagement.DTO.EmployeeDTO;
import com.EmployeeManagement.EmployeeManagement.Entity.Employee;
import com.EmployeeManagement.EmployeeManagement.Mapper.EmployeeMapper;
import com.EmployeeManagement.EmployeeManagement.Repository.EmployeeRepository;
import com.EmployeeManagement.EmployeeManagement.Service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployerServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
    @Override
    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {

        Employee employee = EmployeeMapper.mapToEmployee(employeeDTO);
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDTO(savedEmployee);
    }

    @Override
    public EmployeeDTO getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(() -> new ResourceAccessException("not found"));
        return EmployeeMapper.mapToEmployeeDTO(employee);

    }

    @Override
    public List<EmployeeDTO> GetAllEmployees() {

       List<Employee> allEmployees = employeeRepository.findAll();
       return allEmployees.stream().map((emp) -> EmployeeMapper.mapToEmployeeDTO(emp)).collect(Collectors.toList());


    }

    @Override
    public EmployeeDTO UpdateEmployee(Long employeeId, EmployeeDTO updateEmployee) {
       Employee employee = employeeRepository.findById(employeeId).orElseThrow(() -> new ResourceAccessException("not found"));

       employee.setFirstName(updateEmployee.getFirstName());
       employee.setLastName(updateEmployee.getLastName());
       employee.setEmail(updateEmployee.getEmail());
       employeeRepository.save(employee);
       return EmployeeMapper.mapToEmployeeDTO(employee);
    }

    @Override
    public void DeleteEmployee(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(() -> new ResourceAccessException("not found"));
        employeeRepository.delete(employee);

    }
}
