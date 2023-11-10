package com.EmployeeManagement.EmployeeManagement.Repository;

import com.EmployeeManagement.EmployeeManagement.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
