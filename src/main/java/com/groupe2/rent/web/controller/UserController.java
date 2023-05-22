package com.groupe2.rent.web.controller;

import com.groupe2.rent.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import java.util.ArrayList;
import java.util.List;

@RestController
@Api("API pour les operations CRUD sur les users.")

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
    @ApiOperation(value = "Récupère une liste de tous les users")
    @GetMapping("/users")
    public List<User> findAll() {
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
    public String update() {
        return "user updated";
    }


    @PostMapping("/users/")
    public void  create(@RequestBody User user) {
        RestTemplate restTemplate = new RestTemplate();
        Boolean result = restTemplate.getForObject("http://localhost:8081/licenses/{id}", Boolean.class, user.getLicenceNumber());
        if (result){
            listUser.add(user);
        }
    }

    @DeleteMapping( "/users/{id}")
    public String delete(@PathVariable int id) {
        return "user " + id + " deleted";
    }
}
