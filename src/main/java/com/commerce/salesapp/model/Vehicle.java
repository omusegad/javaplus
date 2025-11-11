package com.commerce.salesapp.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="vehicle")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "in_use", nullable = false)
    private boolean inUse;

    @Column(name = "vehicle_type", nullable = false)
    private String vehicleType;
}