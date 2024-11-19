package com.oche1.hospital.system.hospital_management_system.patients;

import com.oche1.hospital.system.hospital_management_system.jpa.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;

    // Get all patients
    public List<PatientDTO> getAllPatients() {
        List<Patient> patients = patientRepository.findAll();
        return patients.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    private PatientDTO convertToDTO(Patient patient) {
        PatientDTO dto = new PatientDTO();
        dto.setId(patient.getId());
        dto.setName(patient.getName());
        dto.setDateOfBirth(patient.getDateOfBirth());
        dto.setGender(patient.getGender());
        dto.setEmail(patient.getEmail());
        dto.setPhone(patient.getPhone());
        return dto;
    }
    // Get a single patient by ID
    public PatientDTO getPatientById(Long id) {
        Patient patient = patientRepository.findById(Math.toIntExact(id))
                .orElseThrow(() -> new RuntimeException("Patient not found with ID: " + id));
        return convertToDTO(patient);
    }
    // Add a new patient
    public PatientDTO addPatient(PatientDTO patientDTO) {
        Patient patient = convertToEntity(patientDTO);
        Patient savedPatient = patientRepository.save(patient);
        return convertToDTO(savedPatient);
    }
    // Update an existing patient
    public PatientDTO updatePatient(Long id, PatientDTO patientDTO) {
        Patient existingPatient = patientRepository.findById(Math.toIntExact(id))
                .orElseThrow(() -> new RuntimeException("Patient not found with ID: " + id));

        // Update fields
        existingPatient.setName(patientDTO.getName());
        existingPatient.setDateOfBirth(patientDTO.getDateOfBirth());
        existingPatient.setGender(patientDTO.getGender());
        existingPatient.setEmail(patientDTO.getEmail());
        existingPatient.setPhone(patientDTO.getPhone());
        existingPatient.setMedicalHistory(patientDTO.getMedicalHistory());
        existingPatient.setAllergies(patientDTO.getAllergies());
        existingPatient.setBloodType(patientDTO.getBloodType());
        existingPatient.setRegistrationDate(patientDTO.getRegistrationDate());

        Patient updatedPatient = patientRepository.save(existingPatient);
        return convertToDTO(updatedPatient);
    }
    // Delete a patient
    public void deletePatient(Long id) {
        if (!patientRepository.existsById(Math.toIntExact(id))) {
            throw new RuntimeException("Patient not found with ID: " + id);
        }
        patientRepository.deleteById(Math.toIntExact(id));
    }
    // Get all medical records for a specific patient

    // Utility method: Convert Patient to PatientDTO

    // Utility method: Convert PatientDTO to Patient
    private Patient convertToEntity(PatientDTO patientDTO) {
        Patient patient = new Patient();
        patient.setName(patientDTO.getName());
        patient.setDateOfBirth(patientDTO.getDateOfBirth());
        patient.setGender(patientDTO.getGender());
        patient.setEmail(patientDTO.getEmail());
        patient.setPhone(patientDTO.getPhone());
        patient.setMedicalHistory(patientDTO.getMedicalHistory());
        patient.setAllergies(patientDTO.getAllergies());
        patient.setBloodType(patientDTO.getBloodType());
        patient.setRegistrationDate(patientDTO.getRegistrationDate());
        return patient;
    }

}