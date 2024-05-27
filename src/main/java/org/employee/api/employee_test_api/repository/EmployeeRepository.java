package org.employee.api.employee_test_api.repository;

import org.employee.api.employee_test_api.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
