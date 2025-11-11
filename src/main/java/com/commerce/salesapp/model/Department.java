package com.commerce.salesapp.model;


import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;


/**
 * Define Department Table
 */

@Entity
@Data
@NoArgsConstructor
@Table(name = "department")
public class Department {

    @Id @GeneratedValue
    private Long id;
    private String name;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}