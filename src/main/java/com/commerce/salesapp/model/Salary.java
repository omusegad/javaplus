package com.commerce.salesapp.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="salary")
@Data
@NoArgsConstructor
public class Salary {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean isActive;
    private float salaryAmount;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

}