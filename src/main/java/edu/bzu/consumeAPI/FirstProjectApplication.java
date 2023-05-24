package edu.bzu.consumeAPI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
public class FirstProjectApplication {

    private static final Logger log = LoggerFactory.getLogger(FirstProjectApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(FirstProjectApplication.class, args);
    }

    @GetMapping("/sayHi")
    public String hello(@RequestParam(value = "name", defaultValue = "BZU") String name) {
        return String.format("Hello there %s!", name);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
        return args -> {
//            User user = restTemplate.getForObject(
//                    "https://gorest.co.in/public/v2/users", User.class);

//            UserList response = restTemplate.getForObject(
//                    "https://gorest.co.in/public/v2/users", UserList.class);
//
//            List<User> userList = response.getUserList();
//            for (User instance :
//                    userList) {
//                log.info(instance.toString());
//            }
            ResponseEntity<User[]> response =
                    restTemplate.getForEntity(
                            "https://gorest.co.in/public/v2/users",
                            User[].class);
            User[] userList = response.getBody();
            for (User instance :
                    userList) {
                log.info(instance.toString());
            }
        };
    }


    @Bean
    public CommandLineRunner demo(CustomerRepository repository) {
        return (args) -> {
            // save a few customers
            repository.save(new Customer("Jack", "Bauer"));
            repository.save(new Customer("Chloe", "O'Brian"));
            repository.save(new Customer("Kim", "Bauer"));
            repository.save(new Customer("David", "Palmer"));
            repository.save(new Customer("Michelle", "Dessler"));

            // fetch all customers
            log.info("Customers found with findAll():");
            log.info("-------------------------------");
            for (Customer customer : repository.findAll()) {
                log.info(customer.toString());
            }
            log.info("");

            // fetch an individual customer by ID
            Customer customer = repository.findById(1L);
            log.info("Customer found with findById(1L):");
            log.info("--------------------------------");
            log.info(customer.toString());
            log.info("");

            // fetch customers by last name
            log.info("Customer found with findByLastName('Bauer'):");
            log.info("--------------------------------------------");
            repository.findByLastName("Bauer").forEach(bauer -> {
                log.info(bauer.toString());
            });
            // for (Customer bauer : repository.findByLastName("Bauer")) {
            //  log.info(bauer.toString());
            // }
            log.info("");
        };
    }

}
