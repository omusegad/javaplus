package com.commerce.salesapp.contoller;

import com.commerce.salesapp.model.Patient;
import com.commerce.salesapp.service.PatientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/records")

public class PatientRecordsController {

    private final PatientService patientService;

    public PatientRecordsController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping
    public ResponseEntity<List<Patient>> getPatientRecords(){
        List<Patient> patients = patientService.getAllPatient();
        if (patients.isEmpty()){
            ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(patients);
    }

    @PostMapping
    public ResponseEntity<Patient> createPatient(@RequestBody Patient patient){
        Patient savedPatient = patientService.createPatientRecords(patient);
        return new ResponseEntity<>(savedPatient, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePatient(@PathVariable Long id){
        patientService.deletePatientById(id);
        return ResponseEntity.noContent().build();
    }




}