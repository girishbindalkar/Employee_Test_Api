package org.employee.api.employee_test_api.controller;

import lombok.AllArgsConstructor;
import org.employee.api.employee_test_api.Entity.Address;
import org.employee.api.employee_test_api.repository.AddressRepository;
import org.employee.api.employee_test_api.repository.EmployeeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/address")
public class AddressController {


    private final AddressRepository addressRepository;
    private final EmployeeRepository employeeRepository;
    @PostMapping
    public ResponseEntity<Address> createAddress(@RequestBody Address address) {
        if (employeeRepository.findById(address.getEmployee().getEid()).isPresent()) {
            return new ResponseEntity<>(addressRepository.save(address), HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Address> updateAddress(@PathVariable Long id, @RequestBody Address address) {
        if (addressRepository.findById(id).isPresent()) {
            address.setAid(id);
            return new ResponseEntity<>(addressRepository.save(address), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/employee/{employeeId}")
    public ResponseEntity<List<Address>> getAddressesByEmployeeId(@PathVariable Long employeeId) {
        if (employeeRepository.findById(employeeId).isPresent()) {
            return new ResponseEntity<>(addressRepository.findAll().stream()
                    .filter(address -> address.getEmployee().getEid().equals(employeeId))
                    .collect(Collectors.toList()), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
