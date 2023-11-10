package com.EmployeeManagement.EmployeeManagement.Service;

import com.EmployeeManagement.EmployeeManagement.DTO.EmployeeDTO;

import java.util.List;

public interface EmployeeService {
    EmployeeDTO createEmployee(EmployeeDTO employeeDTO);
    EmployeeDTO getEmployeeById(Long employeeId);

    List<EmployeeDTO> GetAllEmployees();
    EmployeeDTO UpdateEmployee(Long employeeId, EmployeeDTO updateEmployee);
    void DeleteEmployee(Long employeeId);


}
