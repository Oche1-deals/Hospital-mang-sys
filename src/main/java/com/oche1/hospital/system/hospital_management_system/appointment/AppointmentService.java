package com.oche1.hospital.system.hospital_management_system.appointment;

import com.oche1.hospital.system.hospital_management_system.jpa.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {
    @Autowired
    private AppointmentRepository appointmentRepository;

    // Create or Update Appointment
    public Appointment saveAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }
    // Get Appointment by ID
    public Optional<Appointment> getAppointmentById(Long id) {
        return appointmentRepository.findById(id);
    }

    // Get All Appointments for a Patient
    public List<Appointment> getAppointmentsByPatientId(Long patientId) {
        return appointmentRepository.findByPatientId(patientId);
    }

    // Get All Appointments for a Doctor
    public List<Appointment> getAppointmentsByDoctorId(Long doctorId) {
        return appointmentRepository.findByDoctorId(doctorId);
    }
    // Delete Appointment by ID
    public void deleteAppointment(Long id) {
        appointmentRepository.deleteById(id);
    }
}
