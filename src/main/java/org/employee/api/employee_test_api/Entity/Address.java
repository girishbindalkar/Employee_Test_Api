package org.employee.api.employee_test_api.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "tbl_address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long aid;

    @Column(name="street", nullable=true)
    private String street;
    @Column(name="city", nullable=true)
    private String city;
    @Column(name="state", nullable=true)
    private String state;
    @Column(name="zip", nullable = true)
    private String zip;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
}
