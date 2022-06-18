package br.com.ramagalhaes.fraud;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class FraudCheckHistory {

    @Id
    @SequenceGenerator(
            name = "sequence_id_fraud",
            sequenceName = "sequence_id_fraud"
    )
    @GeneratedValue(
            generator = "sequence_id_fraud",
            strategy = GenerationType.SEQUENCE
    )
    private Integer id;
    private Integer customerId;
    private Boolean isFraudster;
    private LocalDateTime createdAt;

}
