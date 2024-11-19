package com.oche1.hospital.system.hospital_management_system.appointment;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Validated
public class AppointmentController {
    @Autowired
    private AppointmentService appointmentService;

    // Create a new Appointment
    @PostMapping("appointment")
    public ResponseEntity<Appointment> createAppointment(@Valid @RequestBody Appointment appointment) {
        Appointment savedAppointment = appointmentService.saveAppointment(appointment);
        return new ResponseEntity<>(savedAppointment, HttpStatus.CREATED);
    }
    // Get Appointment by ID
    @GetMapping("appointment/{id}")
    public ResponseEntity<Appointment> getAppointmentById(@PathVariable Long id) {
        Optional<Appointment> appointment = appointmentService.getAppointmentById(id);
        return appointment.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Get All Appointments for a Patient
    @GetMapping("appointment/patient/{patientId}")
    public ResponseEntity<List<Appointment>> getAppointmentsByPatientId(@PathVariable Long patientId) {
        List<Appointment> appointments = appointmentService.getAppointmentsByPatientId(patientId);
        return new ResponseEntity<>(appointments, HttpStatus.OK);
    }
    // Get All Appointments for a Doctor
    @GetMapping("appointment/doctor/{doctorId}")
    public ResponseEntity<List<Appointment>> getAppointmentsByDoctorId(@PathVariable Long doctorId) {
        List<Appointment> appointments = appointmentService.getAppointmentsByDoctorId(doctorId);
        return new ResponseEntity<>(appointments, HttpStatus.OK);
    }
    // Update Appointment
    @PutMapping("appointment/{id}")
    public ResponseEntity<Appointment> updateAppointment(
            @PathVariable Long id,
            @Valid @RequestBody Appointment appointment
    ) {
        Optional<Appointment> existingAppointment = appointmentService.getAppointmentById(id);
        if (existingAppointment.isPresent()) {
            appointment.setId(id);
            Appointment updatedAppointment = appointmentService.saveAppointment(appointment);
            return new ResponseEntity<>(updatedAppointment, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    // Delete Appointment
    @DeleteMapping("appointment/{id}")
    public ResponseEntity<Void> deleteAppointment(@PathVariable Long id) {
        Optional<Appointment> existingAppointment = appointmentService.getAppointmentById(id);
        if (existingAppointment.isPresent()) {
            appointmentService.deleteAppointment(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
