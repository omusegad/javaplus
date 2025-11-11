package com.commerce.salesapp.service;

import com.commerce.salesapp.model.Job;
import com.commerce.salesapp.repository.JobListingsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobListingService {

    private final JobListingsRepository jobListingsRepository;

    public JobListingService(JobListingsRepository jobListingsRepository) {
        this.jobListingsRepository = jobListingsRepository;
    }

    public List<Job> getJobs(){
        return jobListingsRepository.findAll();
    }

    public Job findJobById(Long id){
        return jobListingsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Job not found"));
    }

    public void deleteJob(Long id){
        if(jobListingsRepository.existsById(id)){
            jobListingsRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Job not found");
        }
    }


}