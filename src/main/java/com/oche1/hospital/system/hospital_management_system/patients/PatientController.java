package com.oche1.hospital.system.hospital_management_system.patients;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
public class PatientController {
    @Autowired
    private PatientService patientService;

    // Get all patients
    @GetMapping("patients")
    public ResponseEntity<List<PatientDTO>> getAllPatients() {
        List<PatientDTO> patients = patientService.getAllPatients();
        return new ResponseEntity<>(patients, HttpStatus.OK);
    }

    // Get a specific patient by ID
    @GetMapping("patient/{id}")
    public ResponseEntity<PatientDTO> getPatientById(@PathVariable Long id) {
        PatientDTO patient = patientService.getPatientById(id);
        return new ResponseEntity<>(patient, HttpStatus.OK);
    }
    // Add a new patient
    @PostMapping("patients")
    public ResponseEntity<PatientDTO> addPatient(@RequestBody PatientDTO patientDTO) {
        PatientDTO createdPatient = patientService.addPatient(patientDTO);
        return new ResponseEntity<>(createdPatient, HttpStatus.CREATED);
    }
    // Update a patient
    @PutMapping("patient/{id}")
    public ResponseEntity<PatientDTO> updatePatient(@PathVariable Long id, @RequestBody PatientDTO patientDTO) {
        PatientDTO updatedPatient = patientService.updatePatient(id, patientDTO);
        return new ResponseEntity<>(updatedPatient, HttpStatus.OK);
    }

    // Delete a patient
    @DeleteMapping("patient/{id}")
    public ResponseEntity<Void> deletePatient(@PathVariable Long id) {
        patientService.deletePatient(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Get all medical records for a specific patient


}
