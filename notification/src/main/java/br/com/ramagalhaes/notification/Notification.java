package br.com.ramagalhaes.notification;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import java.time.LocalDateTime;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Notification {

    @SequenceGenerator(
            name = "sequence_id_notification",
            sequenceName = "sequence_id_notification"
    )
    @GeneratedValue(
            generator = "sequence_id_notification"
    )
    @Id
    private Integer notificationId;
    private Integer toCustomerId;
    private String toCustomerEmail;
    private String sender;
    private String message;
    private LocalDateTime sentAt;
}
