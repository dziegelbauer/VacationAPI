package edu.wgu.d288.bootstrap;

import edu.wgu.d288.dao.CustomerRepository;
import edu.wgu.d288.dao.DivisionRepository;
import edu.wgu.d288.entities.Customer;
import edu.wgu.d288.entities.Division;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class BootstrapData implements CommandLineRunner {
    private final CustomerRepository customerRepository;
    private final DivisionRepository divisionRepository;

    @Override
    public void run(String... args) throws Exception {
        if(customerRepository.count() < 2) {
            List<Division> divisions = divisionRepository.findAll();

            Customer customer1 = Customer.builder()
                    .firstName("Dave")
                    .lastName("Ziegelbauer")
                    .address("123 Rocky Road")
                    .postal_code("12345")
                    .phone("1234567890")
                    .division(divisions.get(0))
                    .build();

            Customer customer2 = Customer.builder()
                    .firstName("Joe")
                    .lastName("Avocado")
                    .address("456 Deep Lake St")
                    .postal_code("12345")
                    .phone("2345678901")
                    .division(divisions.get(0))
                    .build();

            Customer customer3 = Customer.builder()
                    .firstName("Mike")
                    .lastName("Ranchero")
                    .address("789 High Ave Apt 23")
                    .postal_code("12345")
                    .phone("3456789012")
                    .division(divisions.get(0))
                    .build();

            Customer customer4 = Customer.builder()
                    .firstName("Josie")
                    .lastName("Appleblatt")
                    .address("264 Swinging Tree CT")
                    .postal_code("12345")
                    .phone("4567890123")
                    .division(divisions.get(0))
                    .build();

            Customer customer5 = Customer.builder()
                    .firstName("Ann")
                    .lastName("Arundel")
                    .address("846 Jersey Way")
                    .postal_code("12345")
                    .phone("5678901234")
                    .division(divisions.get(0))
                    .build();

            customerRepository.saveAll(List.of(customer1, customer2, customer3, customer4, customer5));
        }
    }
}
