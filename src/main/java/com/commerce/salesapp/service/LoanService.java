package com.commerce.salesapp.service;

import com.commerce.salesapp.model.Loan;
import com.commerce.salesapp.repository.LoanRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanService {

    private final LoanRepository loanRepository;

    public LoanService(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    public List<Loan> getAllLoans(){
        return loanRepository.findAll();
    }

    public void createLoan(Loan loan){
     loanRepository.save(loan);
    }

    public void deleteLoan(Long id){
        if(loanRepository.existsById(id)){
            loanRepository.deleteById(id);
        }
        throw  new EntityNotFoundException("Loan not found");
    }

}