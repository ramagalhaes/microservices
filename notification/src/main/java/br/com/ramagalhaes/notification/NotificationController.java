package br.com.ramagalhaes.notification;

import br.com.ramagalhaes.clients.notification.NotificationRequest;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/notifications")
public class NotificationController {

    private final NotificationService service;


    @PostMapping
    public void sendRequest(@RequestBody NotificationRequest notificationRequest) {
        this.service.sendNotification(notificationRequest);
    }
}
