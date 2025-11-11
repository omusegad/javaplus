package com.commerce.salesapp.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.commerce.salesapp.model.Job;

@Repository
public interface JobListingsRepository extends JpaRepository<Job, Long >{
}