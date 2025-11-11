package com.commerce.salesapp.contoller;

import com.commerce.salesapp.model.Job;
import com.commerce.salesapp.service.JobListingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/job-listing")
public class JobListingsController {

    private final JobListingService jobListingService;

    public JobListingsController(JobListingService jobListingService) {
        this.jobListingService = jobListingService;
    }

    @PostMapping()
    public ResponseEntity<List<Job>> getAllJobs(){
        List<Job> jobs = jobListingService.getJobs();
        if(jobs.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(jobs);
    }

    @GetMapping
    public ResponseEntity<List<Job>> fetchAllJobs(){
        List<Job> jobs = jobListingService.getJobs();
        if(jobs.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(jobs);
    }

    @PostMapping("/{id}")
    public ResponseEntity<Void> findJobById(@PathVariable Long id){
      Job result = jobListingService.findJobById(id);
      if (result.isEmpty()){
          return ResponseEntity.noContent().build();
      }
      return ResponseEntity.ok().build();
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJob(Long id){
        jobListingService.deleteJob(id);
        return ResponseEntity.noContent().build();
    }
}