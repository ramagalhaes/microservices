package br.com.ramagalhaes.notification;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication( scanBasePackages = {"br.com.ramagalhaes.notification", "br.com.ramagalhaes.amqp"})
@EnableEurekaClient
@EnableFeignClients(basePackages = "br.com.ramagalhaes.clients")
public class NotificationApplication {

    public static void main(String[] args) {
        SpringApplication.run(NotificationApplication.class, args);
    }

}
