package com.commerce.salesapp.contoller;

import com.commerce.salesapp.model.Recruiter;
import com.commerce.salesapp.service.RecruiterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/recruiters")
public class RecruiterController {
    private final RecruiterService recruiterService;

    public RecruiterController(RecruiterService recruiterService, RecruiterService recruiterService1) {
        this.recruiterService = recruiterService1;
    }

    @GetMapping
    public ResponseEntity<Recruiter> getRecruiters(){
        List<Recruiter> recruiters = recruiterService.getAllRecruiters();
        if(recruiters.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(recruiters);
    }

}