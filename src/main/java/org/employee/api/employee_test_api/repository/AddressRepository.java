package org.employee.api.employee_test_api.repository;

import org.employee.api.employee_test_api.Entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}