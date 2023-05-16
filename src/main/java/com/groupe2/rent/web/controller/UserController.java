package com.groupe2.rent.web.controller;
import com.groupe2.rent.model.User;
import org.springframework.web.bind.annotation.*;

import java.awt.desktop.UserSessionEvent;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
    private List<User> listUser;

    public UserController() {
        listUser = new ArrayList<>();
        User user1 = new User(1,"Shelby", "Tommy", "22-1-1982", "ABC123456");
        User user2 = new User(2,"Doe", "John", "22-1-1983", "ABC123455");
        User user3 = new User(3,"Specter ", "Harvey", "22-1-1984", "ABC123454");
        listUser.add(user1);
        listUser.add(user2);
        listUser.add(user3);
    }

    @GetMapping("/users")
    public List<User> list() {
        return listUser;
    }

    @GetMapping("/users/{id}")
    public User show(@PathVariable int id) {
        for (User currentUser : listUser) {
            if (currentUser.getId() == id) {
                return currentUser;
            }
        }
        return null ;
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
