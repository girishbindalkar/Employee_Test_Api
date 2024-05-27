package org.employee.api.employee_test_api.service;

import org.employee.api.employee_test_api.Entity.Employee;
import org.employee.api.employee_test_api.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeService {

    Employee createEmployee(Employee employeeDTO);
    Employee updateEmployee(Long id, Employee employeeDTO);
    EmployeeDTO getEmployeeById(Long id);
    List<Employee> getAllEmployees(String search, String sortBy);
    void deleteEmployee(Long id);
}
