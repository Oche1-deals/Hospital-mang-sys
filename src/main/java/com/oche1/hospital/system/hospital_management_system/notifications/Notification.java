package com.oche1.hospital.system.hospital_management_system.notifications;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String recipient; // Email or phone number
    private String type;      // EMAIL, SMS, PUSH
    private String message;   // The content of the notification
    private boolean sent;     // Whether the notification has been sent
    private LocalDateTime timestamp; // When the notification was created

    public Notification() {
    }
    public Notification(String recipient, String type, String message, boolean sent, LocalDateTime timestamp) {
        this.recipient = recipient;
        this.type = type;
        this.message = message;
        this.sent = sent;
        this.timestamp = timestamp;
    }

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSent() {
        return sent;
    }

    public void setSent(boolean sent) {
        this.sent = sent;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

}
