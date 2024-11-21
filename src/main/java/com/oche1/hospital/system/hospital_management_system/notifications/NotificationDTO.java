package com.oche1.hospital.system.hospital_management_system.notifications;

import java.time.LocalDateTime;

public class NotificationDTO {
    private Long id;
    private String recipient;
    private String message;
    private String type;
    private LocalDateTime timestamp;



    public  NotificationDTO(Long id, String recipient, String message,
                                String type, LocalDateTime timestamp) {
        this.id = id;
        this.recipient = recipient;
        this.message = message;
        this.type = type;
        this.timestamp = timestamp;
    }

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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
