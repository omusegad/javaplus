package com.commerce.salesapp.contoller;

import com.commerce.salesapp.model.Loan;
import com.commerce.salesapp.service.LoanService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/loans")
public class LoanController {

    private final LoanService loanService;

    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    @GetMapping
    public ResponseEntity<List<Loan>> getAllLoans(){
        List<Loan> loans = loanService.getAllLoans();
        if (loans.isEmpty()){
            ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(loans);
    }

    @PostMapping
    public ResponseEntity<String> addLoan(@RequestBody Loan loan){
        loanService.createLoan(loan);
        return ResponseEntity.status(HttpStatus.CREATED).body("Loan created successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLoan(@PathVariable Long id ){
        loanService.deleteLoan(id);
        return ResponseEntity.noContent().build();
    }

}