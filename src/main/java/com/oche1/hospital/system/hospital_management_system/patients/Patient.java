package com.oche1.hospital.system.hospital_management_system.patients;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "patients")
public class Patient {

    protected Patient(){

    }

    @Id
    @GeneratedValue
    private Long id;                // Unique identifier for the patient
    private String name;       // First name of the patient
    private LocalDate dateOfBirth;  // Date of birth
    private String gender;          // Gender (e.g., "Male", "Female", "Other")
    private String email;           // Contact email
    private String phone;           // Contact phone number
    private String medicalHistory;  // Short summary of medical history
    private String allergies;       // Known allergies
    private String bloodType;       // Blood type (e.g., "A+", "O-")
    private LocalDate registrationDate; // Date when the patient registered at the hospital

    public Patient(Long id, String name, LocalDate dateOfBirth, String gender,
                   String email, String phone, String medicalHistory, String allergies,
                   String bloodType, LocalDate registrationDate) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.email = email;
        this.phone = phone;
        this.medicalHistory = medicalHistory;
        this.allergies = allergies;
        this.bloodType = bloodType;
        this.registrationDate = registrationDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    public String getAllergies() {
        return allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", medicalHistory='" + medicalHistory + '\'' +
                ", allergies='" + allergies + '\'' +
                ", bloodType='" + bloodType + '\'' +
                ", registrationDate=" + registrationDate +
                '}';
    }
}