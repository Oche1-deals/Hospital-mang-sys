package com.oche1.hospital.system.hospital_management_system.notifications;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NotificationController {
    @Autowired
    private NotificationService notificationService;

    @GetMapping("notifications")
    public ResponseEntity<List<NotificationDTO>> getAllNotifications() {
        return ResponseEntity.ok(notificationService.getAllNotifications());
    }

    @GetMapping("notifications/{id}")
    public ResponseEntity<NotificationDTO> getNotificationById(@PathVariable Long id) {
        return ResponseEntity.ok(notificationService.getNotificationById(id));
    }
    @PostMapping("notification")
    public ResponseEntity<String> sendNotification(@RequestParam String recipient,
                                                   @RequestParam String message,
                                                   @RequestParam String type) {
        notificationService.sendNotification(recipient, message, type);
        return ResponseEntity.ok("Notification sent successfully.");
    }
}
