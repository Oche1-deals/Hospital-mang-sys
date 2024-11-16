package com.oche1.hospital.system.hospital_management_system.jpa;

import com.oche1.hospital.system.hospital_management_system.doctor.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    public default List<Doctor> getDoctorsBySpecialization(String specialization) {
        return findBySpecialization(specialization);
    }

    List<Doctor> findBySpecialization(String specialization);
}
