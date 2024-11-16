package com.oche1.hospital.system.hospital_management_system.patients;

import com.oche1.hospital.system.hospital_management_system.jpa.PatientRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class PatientResource {
    private PatientRepository repository;

    public PatientResource(PatientRepository repository) {
        this.repository = repository;
    }
    @GetMapping("patients")
    public List<Patient> retriveAllPatients(){
        return repository.findAll();
    }
    @GetMapping("patients/{id}")
    public Patient retrivePatient(@PathVariable Integer id){
        Patient patient = repository.findById(id).orElse(null);
        if(patient== null)
            throw new UserNotFoundException("id:"+id);

        return patient;
    }
    @DeleteMapping("/patients/{id}")
    public void deletePatient(@PathVariable int id){
        repository.deleteById(id);
    }
    @PostMapping("/patients")
    public ResponseEntity<Patient> createPatient(@Valid @RequestBody Patient patient){
        Patient savedPatient = repository.save(patient);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
        .path("/{id}").buildAndExpand(savedPatient.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

}
