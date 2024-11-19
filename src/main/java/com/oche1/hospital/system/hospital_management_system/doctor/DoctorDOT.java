package com.oche1.hospital.system.hospital_management_system.doctor;

public class DoctorDOT {
    private Long id;
    private String firstName;
    private String lastName;
    private String specialization;
    private String email;
    private String phone;
    private Boolean availability;

    // Constructors, Getters, Setters

    public DoctorDOT(){

    }

    public DoctorDOT(Long id, String firstName, String lastName,
                     String specialization, String email, String phone,
                     Boolean availability) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.specialization = specialization;
        this.email = email;
        this.phone = phone;
        this.availability = availability;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
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

    public Boolean getAvailability() {
        return availability;
    }

    public void setAvailability(Boolean availability) {
        this.availability = availability;
    }

    @Override
    public String toString() {
        return "DoctorDOT{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", specialization='" + specialization + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", availability=" + availability +
                '}';
    }
}
