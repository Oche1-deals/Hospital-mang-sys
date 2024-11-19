package com.oche1.hospital.system.hospital_management_system.jpa;

import com.oche1.hospital.system.hospital_management_system.appointment.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment,Long> {
    List<Appointment> findByPatientId(Long patientId);
    List<Appointment> findByDoctorId(Long doctorId);
}
