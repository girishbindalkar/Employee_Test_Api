package org.employee.api.employee_test_api.service;

import lombok.AllArgsConstructor;
import org.employee.api.employee_test_api.Entity.Address;
import org.employee.api.employee_test_api.Entity.Employee;
import org.employee.api.employee_test_api.dto.AddressDTO;
import org.employee.api.employee_test_api.dto.EmployeeDTO;
import org.employee.api.employee_test_api.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private final EmployeeRepository employeeRepository;
    @Override
    public Employee createEmployee(Employee employeeDTO) {
        Employee employee = new Employee();
        employee.setName(employeeDTO.getName());
        employee.setAddresses(employeeDTO.getAddresses());

        employee = employeeRepository.save(employeeDTO);
        return employeeDTO;
    }



    @Override
    public Employee updateEmployee(Long id, Employee employeeDTO) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
        employee.setName(employeeDTO.getName());
        employee = employeeRepository.save(employee);
        return employee;
    }

    @Override
    public EmployeeDTO getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
        return convertToDTO(employee);
    }

    @Override
    public List<Employee> getAllEmployees(String search, String sortBy) {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream()
                .filter(employee -> employee.getName().contains(search))
                .sorted((e1, e2) -> {
                    if ("asc".equalsIgnoreCase(sortBy)) {
                        return e1.getName().compareTo(e2.getName());
                    } else {
                        return e2.getName().compareTo(e1.getName());
                    }
                })


                .collect(Collectors.toList());
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    private EmployeeDTO convertToDTO(Employee employee) {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId(employee.getEid());
        employeeDTO.setName(employee.getName());
       // employeeDTO.setAddresses(employee.getAddresses());
        return employeeDTO;
    }

}
