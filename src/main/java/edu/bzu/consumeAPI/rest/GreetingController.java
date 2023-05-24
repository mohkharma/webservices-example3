package edu.bzu.consumeAPI.rest;

import edu.bzu.consumeAPI.Greeting;
import edu.bzu.consumeAPI.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.atomic.AtomicLong;

@RestController()
@RequestMapping(path = "/greeting")
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/last")
    public Greeting last(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    @GetMapping("/all")
    public User[] all(@RequestParam(value = "name", defaultValue = "World") String name) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<User[]> response =
                restTemplate.getForEntity(
                        "https://gorest.co.in/public/v2/users",
                        User[].class);
        User[] userList = response.getBody();

        return userList;
    }
}