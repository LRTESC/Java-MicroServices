package com.groupe2.rent.web.controller;
import com.groupe2.rent.model.User;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @GetMapping("/users")
    public String list() {
        return "users";
    }

    @GetMapping("/users/{id}")
    public User show(@PathVariable int id) {
        User user = new User(id,"Shelby", "Tommy", "22-1-1982", "ABC123456");
        return user;
    }

    @PutMapping( "/users/{id}")
    public String update(@PathVariable int id) {
        return "user " + id + " updated";
    }

    @PostMapping("/users/")
    public String create() {
        return "user created";
    }

    @DeleteMapping( "/users/{id}")
    public String delete(@PathVariable int id) {
        return "user " + id + " deleted";
    }
}
