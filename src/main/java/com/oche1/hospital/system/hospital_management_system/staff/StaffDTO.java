package com.oche1.hospital.system.hospital_management_system.staff;

import java.time.LocalDate;

public class StaffDTO {

        private Long id;
        private String fullName;
        private String email;
        private String role;
        private LocalDate hireDate;

        public StaffDTO(Long id, String fullName, String email, String role, LocalDate hireDate) {
            this.id = id;
            this.fullName = fullName;
            this.email = email;
            this.role = role;
            this.hireDate = hireDate;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getFullName() {
            return fullName;
        }

        public void setFullName(String fullName) {
            this.fullName = fullName;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
        }

        public LocalDate getHireDate() {
            return hireDate;
        }

        public void setHireDate(LocalDate hireDate) {
            this.hireDate = hireDate;
        }
    }

