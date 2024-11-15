package com.oche1.hospital.system.hospital_management_system.patients;

import com.oche1.hospital.system.hospital_management_system.jpa.PatientRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class PatientResource {
    private PatientRepository repository;

    public PatientResource(PatientRepository repository) {
        this.repository = repository;
    }
    @GetMapping("patients")
    public List<Patient> retriveAllUser(){
        return repository.findAll();
    }
    @DeleteMapping("/patients/{id}")
    public void deletePatient(@PathVariable int id){
        repository.deleteById(id);
    }
    @PostMapping("/patients")
    public ResponseEntity<Patient> createUser(@Valid @RequestBody Patient patient){
        Patient savedUser = repository.save(patient);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

}
