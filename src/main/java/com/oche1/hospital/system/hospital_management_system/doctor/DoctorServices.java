package com.oche1.hospital.system.hospital_management_system.doctor;

import com.oche1.hospital.system.hospital_management_system.jpa.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorServices {

    @Autowired
    private DoctorRepository doctorRepository;

    // Create or Update Doctor
    public Doctor saveDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }
    // Get Doctor by ID
    public Optional<Doctor> getDoctorById(Long id) {
        return doctorRepository.findById(id);
    }

    // Get All Doctors
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    // Delete Doctor by ID
    public void deleteDoctor(Long id) {
        doctorRepository.deleteById(id);
    }

    // Find Doctors by Specialization
    public List<Doctor> getDoctorsBySpecialization(String specialization) {
        return doctorRepository.findBySpecialization(specialization);
    }
}
