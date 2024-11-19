package com.oche1.hospital.system.hospital_management_system.jpa;

import com.oche1.hospital.system.hospital_management_system.doctor.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    // Custom query methods can be added here
    List<Doctor> findBySpecialization(String specialization);

    List<Doctor> getDoctorsBySpecialization(String specialization);
}
