package com.commerce.salesapp.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalTime;
import java.util.List;

enum Role{
    AUTHOR,
    ADMINISTRATOR,
    EDITOR,
}

@Data
@Entity
@Table(name="user")
@NoArgsConstructor
@AllArgsConstructor
public  class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Email(message = "Email is required")
    @Column(unique = true, nullable = false)
    private String email;

    @NotBlank(message = "First Name kis required")
    @Column(name = "first_name")
    private String firstName;

    @NotBlank(message = "Last name is required")
    @Column(name = "last_name")
    private String lastName;

    @NotBlank(message = "Occupation is required")
    private String occupation;

    private Role  role;

    @CreatedDate
    @Column(name="created_at")
    private LocalTime createdAt;

    @LastModifiedDate
    @Column(name = "update_at")
    private LocalTime updatedAt;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Profile profile;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Salary salary;

    @ManyToOne
    private Department department;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Artist> artist;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name="user_course",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private List<Course> course;

}