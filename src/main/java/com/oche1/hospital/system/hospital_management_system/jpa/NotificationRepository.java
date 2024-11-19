package com.oche1.hospital.system.hospital_management_system.jpa;

import com.oche1.hospital.system.hospital_management_system.notifications.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {
    List<Notification> findByRecipient(String recipient);
    List<Notification> findBySentFalse();
}
