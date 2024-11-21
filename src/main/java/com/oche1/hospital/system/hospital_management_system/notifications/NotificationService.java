package com.oche1.hospital.system.hospital_management_system.notifications;

import com.oche1.hospital.system.hospital_management_system.jpa.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NotificationService {
    @Autowired
    private NotificationRepository notificationRepository;

    public NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    public List<NotificationDTO> getAllNotifications() {
        List<Notification> notifications = notificationRepository.findAll();
        return notifications.stream().map(this::convertToDTO).collect(Collectors.toList());
    }
    public NotificationDTO getNotificationById(Long id) {
        Notification notification = notificationRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Notification not found with ID: " + id));
        return convertToDTO(notification);
    }
    public void sendNotification(String recipient, String message, String type) {
        Notification notification = new Notification(recipient, type, message, false, LocalDateTime.now());
        notificationRepository.save(notification);

        // Simulate sending logic (e.g., email or SMS)
        try {
            if ("EMAIL".equalsIgnoreCase(type)) {
                System.out.println("Sending email to " + recipient);
            } else if ("SMS".equalsIgnoreCase(type)) {
                System.out.println("Sending SMS to " + recipient);
            }
            notification.setSent(true);
        } catch (Exception e) {
            System.err.println("Failed to send notification: " + e.getMessage());
        }

        notificationRepository.save(notification);
    }
    private NotificationDTO convertToDTO(Notification notification) {
        return new NotificationDTO(
                notification.getId(),
                notification.getRecipient(),
                notification.getMessage(),
                notification.getType(),
                notification.getTimestamp()
        );
    }
}
