package com.example.payroll.Model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.payroll.Enum.Status;

@Configuration
public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(EmployeeRepository repository, OrderRepository orderRepository) {
        return args -> {
            log.info("Preloading " + repository.save(new Employee("Bilbo", "Baggins", "Burglar")));
            log.info("Preloading " + repository.save(new Employee("Frodo", "Baggins", "thief")));

            repository.findAll().forEach(employee -> log.info("Preloaded " + employee));

            orderRepository.save(new Order("MacBook pro", Status.COMPLETED));
            orderRepository.save(new Order("Iphone", Status.IN_PROGRESS));
            orderRepository.save(new Order("Samsung vivobook", Status.IN_PROGRESS));

            orderRepository.findAll().forEach(order -> log.info("Preloaded " + order));
        };
    }
}
