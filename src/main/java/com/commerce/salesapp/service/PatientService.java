package com.commerce.salesapp.service;

import com.commerce.salesapp.model.Patient;
import com.commerce.salesapp.repository.PatientRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    private  final  PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public List<Patient> getAllPatient(){
       return patientRepository.findAll();
    }

    public Patient createPatientRecords(Patient patient){
        return patientRepository.save(patient);
    }

    public void deletePatientById( Long id){
        if(patientRepository.existsById(id)){
            patientRepository.deleteById(id);
        }
        throw new EntityNotFoundException("Patience not found");

    }

}