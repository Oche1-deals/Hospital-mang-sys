package com.oche1.hospital.system.hospital_management_system.medicalrecords;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@Entity
public class MedicalRecord {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @NotNull(message = "Patient ID is required")
        private Long patientId;

        @NotBlank(message = "Diagnosis is required")
        private String diagnosis;

        @NotBlank(message = "Treatment details are required")
        private String treatment;

        private String prescription;

        @NotNull(message = "Visit date is required")
        private LocalDate visitDate;

        // Getters and Setters

        public MedicalRecord(Long id, Long patientId, String diagnosis,
                             String treatment, String prescription, LocalDate visitDate) {
                this.id = id;
                this.patientId = patientId;
                this.diagnosis = diagnosis;
                this.treatment = treatment;
                this.prescription = prescription;
                this.visitDate = visitDate;
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

        public String getDiagnosis() {
                return diagnosis;
        }

        public void setDiagnosis(String diagnosis) {
                this.diagnosis = diagnosis;
        }

        public String getTreatment() {
                return treatment;
        }

        public void setTreatment(String treatment) {
                this.treatment = treatment;
        }

        public String getPrescription() {
                return prescription;
        }

        public void setPrescription(String prescription) {
                this.prescription = prescription;
        }

        public LocalDate getVisitDate() {
                return visitDate;
        }

        public void setVisitDate(LocalDate visitDate) {
                this.visitDate = visitDate;
        }

        @Override
        public String toString() {
                return "MedicalRecord{" +
                        "id=" + id +
                        ", patientId=" + patientId +
                        ", diagnosis='" + diagnosis + '\'' +
                        ", treatment='" + treatment + '\'' +
                        ", prescription='" + prescription + '\'' +
                        ", visitDate=" + visitDate +
                        '}';
        }
}

