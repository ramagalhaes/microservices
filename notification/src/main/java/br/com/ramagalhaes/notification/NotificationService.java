package br.com.ramagalhaes.notification;

import br.com.ramagalhaes.clients.notification.NotificationRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Slf4j
@AllArgsConstructor
@Service
public class NotificationService {

    private final NotificationRepository repository;

    public void sendNotification(NotificationRequest request) {
        log.info("Sending notification to: {}", request.toCustomerId());
        this.repository.save(
                Notification.builder()
                        .toCustomerId(request.toCustomerId())
                        .sentAt(LocalDateTime.now())
                        .toCustomerEmail(request.toCustomerEmail())
                        .message(request.message())
                        .sender("Notification service")
                        .build()
        );
    }
}
