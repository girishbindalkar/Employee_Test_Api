package org.employee.api.employee_test_api.dto;

import lombok.Data;

import java.util.List;

@Data
public class EmployeeDTO {
    private Long id;
    private String name;
    private List<AddressDTO> addresses;
}
