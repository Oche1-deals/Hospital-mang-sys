package com.oche1.hospital.system.hospital_management_system.doctor;
import com.oche1.hospital.system.hospital_management_system.jpa.DoctorRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class DoctorResource {
    private DoctorRepository repository;

    public DoctorResource(DoctorRepository repository) {
        this.repository = repository;
    }

    // Create a new Doctor
    @PostMapping("doctor")
    public ResponseEntity<Doctor> createDoctor(@Valid @RequestBody Doctor doctor) {
        Doctor savedDoctor = repository.save(doctor);
        return new ResponseEntity<>(savedDoctor, HttpStatus.CREATED);
    }

    // Get Doctor by ID
    @GetMapping("doctor/{id}")
    public ResponseEntity<Doctor> getDoctorById(@PathVariable Long id) {
        Optional<Doctor> doctor = repository.findById(id);
        if (doctor.isPresent()) {
            return new ResponseEntity<>(doctor.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Get All Doctors
    @GetMapping("doctor")
    public List<Doctor> retriveAllPatients() {
        return repository.findAll();
    }

    // Get Doctors by Specialization
    @GetMapping("doctor/specialization")
    public ResponseEntity<List<Doctor>> getDoctorsBySpecialization(@RequestParam String specialization) {
        List<Doctor> doctors = repository.getDoctorsBySpecialization(specialization);
        return new ResponseEntity<>(doctors, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Doctor> updateDoctor(@PathVariable Long id, @Valid @RequestBody Doctor doctor) {
        Optional<Doctor> existingDoctor = Optional.of(repository.getById(id));
        if (existingDoctor.isPresent()) {
            doctor.setId(id);  // Ensure the ID is preserved
            Doctor updatedDoctor = repository.save(doctor);
            return new ResponseEntity<>(updatedDoctor, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    // Delete Doctor by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDoctor(@PathVariable Long id) {
        Optional<Doctor> existingDoctor = Optional.of(repository.getById(id));
        if (existingDoctor.isPresent()) {
            repository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
}