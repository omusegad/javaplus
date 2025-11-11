package com.commerce.salesapp.service;

import com.commerce.salesapp.model.Recruiter;
import com.commerce.salesapp.repository.RecruiterRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecruiterService {

    private final RecruiterRepository recruiterRepository;

    public RecruiterService(RecruiterRepository recruiterRepository) {
        this.recruiterRepository = recruiterRepository;
    }

    public List<Recruiter> getAllRecruiters(){
       return recruiterRepository.findAll();
    }


}