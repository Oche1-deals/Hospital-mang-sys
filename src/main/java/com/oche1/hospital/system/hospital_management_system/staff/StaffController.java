package com.oche1.hospital.system.hospital_management_system.staff;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StaffController {
    @Autowired
    private StaffService staffService;

    //get all staff
    @GetMapping("staffs")
    public ResponseEntity<List<StaffDTO>> getAllStaff() {
        return ResponseEntity.ok(staffService.getAllStaff());
    }

    //get staff by id.
    @GetMapping("staff/{id}")
    public ResponseEntity<StaffDTO> getStaffById(@PathVariable Long id) {
        return ResponseEntity.ok(staffService.getStaffById(id));
    }
    @PostMapping("staff")
    public ResponseEntity<Staff> createStaff(@RequestBody Staff staff) {
        return ResponseEntity.ok(staffService.createStaff(staff));
    }

    @PutMapping("staff_put/{id}")
    public ResponseEntity<Staff> updateStaff(@PathVariable Long id, @RequestBody Staff updatedStaff) {
        return ResponseEntity.ok(staffService.updateStaff(id, updatedStaff));
    }

    @DeleteMapping("staff/{id}")
    public ResponseEntity<String> deleteStaff(@PathVariable Long id) {
        staffService.deleteStaff(id);
        return ResponseEntity.ok("Staff member deleted successfully.");
    }
}
