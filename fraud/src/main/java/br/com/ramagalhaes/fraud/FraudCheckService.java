package br.com.ramagalhaes.fraud;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
@Slf4j
public class FraudCheckService {

    private final FraudCheckHistoryRepository repository;

    public boolean isFraudulentCustomer(Integer customerId) {
        log.info("Fraud check for customer: {}", customerId);
        this.repository.save(
                FraudCheckHistory.builder()
                        .customerId(customerId)
                        .isFraudster(false)
                        .createdAt(LocalDateTime.now())
                        .build()
        );
        return false;
    }

}
