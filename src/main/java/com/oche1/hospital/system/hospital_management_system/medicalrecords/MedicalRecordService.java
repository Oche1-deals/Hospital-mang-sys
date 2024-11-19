package com.oche1.hospital.system.hospital_management_system.medicalrecords;

import com.oche1.hospital.system.hospital_management_system.jpa.MedicalRecordsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicalRecordService {
    @Autowired
    private MedicalRecordsRepository medicalRecordsRepository;

    // Create or Update Medical Record
    public MedicalRecord saveMedicalRecord(MedicalRecord medicalRecord) {
        return medicalRecordsRepository.save(medicalRecord);
    }

    // Get Medical Record by ID
    public Optional<MedicalRecord> getMedicalRecordById(Long id) {
        return medicalRecordsRepository.findById(id);
    }

    // Get All Medical Records for a Patient
    public List<MedicalRecord> getMedicalRecordsByPatientId(Long patientId) {
        return medicalRecordsRepository.findByPatientId(patientId);
    }

    // Delete Medical Record by ID
    public void deleteMedicalRecord(Long id) {
        medicalRecordsRepository.deleteById(id);
    }
}
