package com.commerce.salesapp.model;


import jakarta.persistence.*;
import lombok.*;

/**
 * Define Address Table
 */

@Entity
@Table(name="Address")
@Data
@NoArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String streetName;
    private int houseNumber;
    private String zipCode;

}