package com.oche1.hospital.system.hospital_management_system.medicalrecords;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/medical-records")
@Validated
public class MedicalRecordController {
    @Autowired
    private MedicalRecordService medicalRecordService;

    // Create a new Medical Record
    @PostMapping("yre")
    public ResponseEntity<MedicalRecord> createMedicalRecord(@Valid @RequestBody MedicalRecord medicalRecord) {
        MedicalRecord savedRecord = medicalRecordService.saveMedicalRecord(medicalRecord);
        return new ResponseEntity<>(savedRecord, HttpStatus.CREATED);
    }

    // Get Medical Record by ID
    @GetMapping("medical_record/{id}")
    public ResponseEntity<MedicalRecord> getMedicalRecordById(@PathVariable Long id) {
        Optional<MedicalRecord> record = medicalRecordService.getMedicalRecordById(id);
        return record.map(medicalRecord -> new ResponseEntity<>(medicalRecord, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    // Get All Medical Records for a Patient
    @GetMapping("/patient/{patientIds}")
    public ResponseEntity<List<MedicalRecord>> getMedicalRecordsByPatientId(@PathVariable Long patientId) {
        List<MedicalRecord> records = medicalRecordService.getMedicalRecordsByPatientId(patientId);
        return new ResponseEntity<>(records, HttpStatus.OK);
    }
    // Update a Medical Record
    @PutMapping("put/{id}")
    public ResponseEntity<MedicalRecord> updateMedicalRecord(
            @PathVariable Long id,
            @Valid @RequestBody MedicalRecord medicalRecord
    ) {
        Optional<MedicalRecord> existingRecord = medicalRecordService.getMedicalRecordById(id);
        if (existingRecord.isPresent()) {
            medicalRecord.setId(id); // Ensure the ID is preserved
            MedicalRecord updatedRecord = medicalRecordService.saveMedicalRecord(medicalRecord);
            return new ResponseEntity<>(updatedRecord, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    // Delete a Medical Record
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteMedicalRecord(@PathVariable Long id) {
        Optional<MedicalRecord> existingRecord = medicalRecordService.getMedicalRecordById(id);
        if (existingRecord.isPresent()) {
            medicalRecordService.deleteMedicalRecord(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
