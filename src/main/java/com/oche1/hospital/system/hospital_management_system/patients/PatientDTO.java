package com.oche1.hospital.system.hospital_management_system.patients;

import java.time.LocalDate;

public class PatientDTO {



    public PatientDTO(){

    }
    public PatientDTO(Long id, String name, LocalDate dateOfBirth,
                      String gender, String email, String phone, String address,
                      String medicalHistory, String allergies, String bloodType,
                      LocalDate registrationDate, String emergencyContactName,
                      String emergencyContactPhone, String emergencyContactRelation) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.medicalHistory = medicalHistory;
        this.allergies = allergies;
        this.bloodType = bloodType;
        this.registrationDate = registrationDate;
        this.emergencyContactName = emergencyContactName;
        this.emergencyContactPhone = emergencyContactPhone;
        this.emergencyContactRelation = emergencyContactRelation;
    }

    private Long id;                // Unique identifier for the patient
    private String name;       // First name of the patient

    private LocalDate dateOfBirth;  // Date of birth
    private String gender;          // Gender (e.g., "Male", "Female", "Other")
    private String email;           // Contact email
    private String phone;           // Contact phone number
    private String address;         // Patient’s address
    private String medicalHistory;  // Short summary of medical history
    private String allergies;       // Known allergies
    private String bloodType;       // Blood type (e.g., "A+", "O-")
    private LocalDate registrationDate; // Date when the patient registered at the hospital

    // Optionally include emergency contact details
    private String emergencyContactName;
    private String emergencyContactPhone;
    private String emergencyContactRelation; // Relationship to patient

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String Name) {
        this.name = Name;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String getEmergencyContactName() {
        return emergencyContactName;
    }

    public void setEmergencyContactName(String emergencyContactName) {
        this.emergencyContactName = emergencyContactName;
    }
    public String getEmergencyContactPhone() {
        return emergencyContactPhone;
    }

    public void setEmergencyContactPhone(String emergencyContactPhone) {
        this.emergencyContactPhone = emergencyContactPhone;
    }

    public String getEmergencyContactRelation() {
        return emergencyContactRelation;
    }

    public void setEmergencyContactRelation(String emergencyContactRelation) {
        this.emergencyContactRelation = emergencyContactRelation;
    }
}
