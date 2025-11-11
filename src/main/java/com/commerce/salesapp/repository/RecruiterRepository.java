package com.commerce.salesapp.repository;

import com.commerce.salesapp.model.Recruiter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RecruiterRepository extends JpaRepository<Recruiter, Long> {
}