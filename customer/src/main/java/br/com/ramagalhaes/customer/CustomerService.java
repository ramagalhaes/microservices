package br.com.ramagalhaes.customer;

import br.com.ramagalhaes.amqp.RabbitMQMessageProducer;
import br.com.ramagalhaes.clients.fraud.FraudCheckResponse;
import br.com.ramagalhaes.clients.fraud.FraudClient;
import br.com.ramagalhaes.clients.notification.NotificationRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository repository;
    private final FraudClient fraudClient;
    private final RabbitMQMessageProducer producer;

    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();
//        toDo: validate fields
        this.repository.saveAndFlush(customer);
        FraudCheckResponse fraudCheckResponse = this.fraudClient.isFraudster(customer.getId());

        if(fraudCheckResponse.isFraudster()) {
            throw new IllegalStateException("Fraudster");
        }
        NotificationRequest notificationRequest = new NotificationRequest(
                customer.getId(),
                customer.getEmail(),
                "user created successfully"
        );

        this.producer.publish(notificationRequest, "internal.exchange", "internal.notification.routing-key");

    }

    private Boolean isEmailAlreadyRegistered(String email) {
        Optional<Customer> customer = this.repository.findByEmail(email);
        return customer.isPresent() ? true : false;
    }

}
