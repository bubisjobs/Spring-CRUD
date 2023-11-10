package com.EmployeeManagement.EmployeeManagement.Controller;

import com.EmployeeManagement.EmployeeManagement.DTO.EmployeeDTO;
import com.EmployeeManagement.EmployeeManagement.Repository.EmployeeRepository;
import com.EmployeeManagement.EmployeeManagement.Service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeDTO> createEmployee(@RequestBody EmployeeDTO employeeDTO){
        EmployeeDTO savedEmployee = employeeService.createEmployee(employeeDTO);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }
    @GetMapping("{id}")
    public  ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable("id") Long employeeId){
        EmployeeDTO employeeDTO = employeeService.getEmployeeById(employeeId);
        return ResponseEntity.ok(employeeDTO);
    }
    @GetMapping
    public  ResponseEntity<List<EmployeeDTO>> getAllEmployees(){
        List<EmployeeDTO> employeeDTO = employeeService.GetAllEmployees();
        return ResponseEntity.ok(employeeDTO);
    }
    @PutMapping("{id}")
    public  ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable("id") Long employeeId,
                                                        @RequestBody EmployeeDTO updatedEmployee){
        EmployeeDTO employeeDTO = employeeService.UpdateEmployee(employeeId, updatedEmployee);
        return ResponseEntity.ok(employeeDTO);
    }
    @DeleteMapping("{id}")
    public  ResponseEntity deleteEmployee(@PathVariable("id") Long employeeId){
        employeeService.DeleteEmployee(employeeId);
        return ResponseEntity.ok("Employee Deleted");
    }


}
