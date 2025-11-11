package com.commerce.salesapp.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Artist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String artistName;

    @Column(nullable = false)
    private String genre;


    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}