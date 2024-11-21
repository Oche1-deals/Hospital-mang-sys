package com.oche1.hospital.system.hospital_management_system.staff;

import com.oche1.hospital.system.hospital_management_system.jpa.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StaffService {
    @Autowired
    private StaffRepository staffRepository;

    public List<StaffDTO> getAllStaff() {
        List<Staff> staffList = staffRepository.findAll();
        return staffList.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public StaffDTO getStaffById(Long id) {
        Staff staff = staffRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Staff not found with ID: " + id));
        return convertToDTO(staff);
    }
    public Staff createStaff(Staff staff) {
        return staffRepository.save(staff);
    }

    public Staff updateStaff(Long id, Staff updatedStaff) {
        Staff existingStaff = staffRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Staff not found with ID: " + id));

        existingStaff.setFirstName(updatedStaff.getFirstName());
        existingStaff.setLastName(updatedStaff.getLastName());
        existingStaff.setEmail(updatedStaff.getEmail());
        existingStaff.setPhone(updatedStaff.getPhone());
        existingStaff.setRole(updatedStaff.getRole());
        existingStaff.setHireDate(updatedStaff.getHireDate());
        existingStaff.setSalary(updatedStaff.getSalary());

        return staffRepository.save(existingStaff);
    }
    public void deleteStaff(Long id) {
        if (!staffRepository.existsById(id)) {
            throw new IllegalArgumentException("Staff not found with ID: " + id);
        }
        staffRepository.deleteById(id);
    }

    private StaffDTO convertToDTO(Staff staff) {
        String fullName = staff.getFirstName() + " " + staff.getLastName();
        return new StaffDTO(
                staff.getId(),
                fullName,
                staff.getEmail(),
                staff.getRole(),
                staff.getHireDate()
        );
    }
}
