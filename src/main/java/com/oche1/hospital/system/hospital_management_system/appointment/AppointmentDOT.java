package com.oche1.hospital.system.hospital_management_system.appointment;

import java.time.LocalDateTime;

public class AppointmentDOT {
    private Long id;
    private Long patientId;
    private Long doctorId;
    private LocalDateTime appointmentDateTime;
    private String status;

    // No-Argument Constructor
   public AppointmentDOT(){

   }

    // Parameterized Constructor

    public AppointmentDOT(Long id, Long patientId, Long doctorId,
                          LocalDateTime appointmentDateTime, String status) {
        this.id = id;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.appointmentDateTime = appointmentDateTime;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public LocalDateTime getAppointmentDateTime() {
        return appointmentDateTime;
    }

    public void setAppointmentDateTime(LocalDateTime appointmentDateTime) {
        this.appointmentDateTime = appointmentDateTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
