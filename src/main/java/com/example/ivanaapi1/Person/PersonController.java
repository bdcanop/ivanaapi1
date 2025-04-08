package com.example.ivanaapi1.Person;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
@RequiredArgsConstructor
public class PersonController {
    private final PersonService personService;

    @PostMapping("create")
    public void createPerson(@RequestBody Person person) {
        personService.createPerson(person);
    }

    @GetMapping
    public String welcome() {
        return "Welcome to Ivana API with security";
    }
}
