package br.com.ramagalhaes.customer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpClient;

@RestController
@RequestMapping("/api/v1/customers")
@Slf4j
public class CustomerController {

    private final CustomerService service;

    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Void> registerCustomer(@RequestBody CustomerRegistrationRequest customerRegistrationRequest) {
        log.info("Customer created {}", customerRegistrationRequest);
        this.service.registerCustomer(customerRegistrationRequest);
        return ResponseEntity.ok().build();
    }

}
