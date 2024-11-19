package com.oche1.hospital.system.hospital_management_system.doctor;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Validated

public class DoctorController {
    @Autowired
    private DoctorServices doctorServices;

    // Create a new Doctor
    @PostMapping("doctor")
    public ResponseEntity<Doctor> createDoctor(@Valid @RequestBody Doctor doctor) {
        Doctor savedDoctor = doctorServices.saveDoctor(doctor);
        return new ResponseEntity<>(savedDoctor, HttpStatus.CREATED);
    }
    // Get Doctor by ID
    @GetMapping("doctor/id/{id}")
    public ResponseEntity<Doctor> getDoctorById(@PathVariable Long id) {
        Optional<Doctor> doctor = doctorServices.getDoctorById(id);
        return doctor.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Get All Doctors
    @GetMapping("doctors")
    public ResponseEntity<List<Doctor>> getAllDoctors() {
        List<Doctor> doctors = doctorServices.getAllDoctors();
        return new ResponseEntity<>(doctors, HttpStatus.OK);
    }
    // Get Doctors by Specialization
    @GetMapping("doctor/sep/{specialization}")
    public ResponseEntity<List<Doctor>> getDoctorsBySpecialization(@PathVariable String specialization) {
        List<Doctor> doctors = doctorServices.getDoctorsBySpecialization(specialization);
        return new ResponseEntity<>(doctors, HttpStatus.OK);
    }
    // Update Doctor
    @PutMapping("doctor/{id}")
    public ResponseEntity<Doctor> updateDoctor(@PathVariable Long id, @Valid @RequestBody Doctor doctor) {
        Optional<Doctor> existingDoctor = doctorServices.getDoctorById(id);
        if (existingDoctor.isPresent()) {
            doctor.setId(id);  // Ensure the ID is preserved
            Doctor updatedDoctor = doctorServices.saveDoctor(doctor);
            return new ResponseEntity<>(updatedDoctor, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    // Delete Doctor by ID
    @DeleteMapping("doctor/{id}")
    public ResponseEntity<Void> deleteDoctor(@PathVariable Long id) {
        Optional<Doctor> existingDoctor = doctorServices.getDoctorById(id);
        if (existingDoctor.isPresent()) {
            doctorServices.deleteDoctor(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
