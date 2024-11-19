package com.oche1.hospital.system.hospital_management_system.jpa;

import com.oche1.hospital.system.hospital_management_system.medicalrecords.MedicalRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MedicalRecordsRepository extends JpaRepository<MedicalRecord, Long> {
    // Fetch medical records by Patient ID
    List<MedicalRecord> findByPatientId(Long patientId);
}
