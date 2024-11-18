package com.oche1.hospital.system.hospital_management_system.medicalrecords;

import com.oche1.hospital.system.hospital_management_system.jpa.MedicalRecordsRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class MedicalRecordsResource {
       private MedicalRecordsRepository repository;

 @PostMapping
 public ResponseEntity<MedicalRecord> createMedicalRecord(@Valid @RequestBody MedicalRecord medicalRecord) {
  MedicalRecord savedRecord = repository.save(medicalRecord);
  return new ResponseEntity<>(savedRecord, HttpStatus.CREATED);
 }

 @GetMapping("/{id}")
 public ResponseEntity<MedicalRecord> getMedicalRecordById(@PathVariable Long id) {
  Optional<MedicalRecord> record = repository.findById(id);
  if (record.isPresent()) {
   return new ResponseEntity<>(record.get(), HttpStatus.OK);
  } else {
   return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }
 }

 // Get All Medical Records for a Patient
 //@GetMapping("/patient/{patientId}")
 //public ResponseEntity<List<MedicalRecord>> getMedicalRecordsByPatientId(@PathVariable Long patientId) {
  //Optional<MedicalRecord> records = repository.findById(patientId);
  //return new ResponseEntity<>(records, HttpStatus.OK);
 //}
 // Update a Medical Record
 @PutMapping("medical/{id}")
 public ResponseEntity<MedicalRecord> updateMedicalRecord(
         @PathVariable Long id,
         @Valid @RequestBody MedicalRecord medicalRecord
 ) {
  Optional<MedicalRecord> existingRecord = Optional.of(repository.getById(id));
  if (existingRecord.isPresent()) {
   medicalRecord.setId(id); // Ensure the ID is preserved
   MedicalRecord updatedRecord = repository.save(medicalRecord);
   return new ResponseEntity<>(updatedRecord, HttpStatus.OK);
  } else {
   return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }
 }
 // Delete a Medical Record
 @DeleteMapping("medical/{id}")
 public ResponseEntity<Void> deleteMedicalRecord(@PathVariable Long id) {
  Optional<MedicalRecord> existingRecord = repository.findById(id);
  if (existingRecord.isPresent()) {
   repository.deleteById(id);
   return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  } else {
   return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }
 }
 }

