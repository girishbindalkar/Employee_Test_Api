package org.employee.api.employee_test_api;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Employee API", version = "1.0", description = "API for managing employees"))
public class EmployeeTestApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmployeeTestApiApplication.class, args);
    }

}
