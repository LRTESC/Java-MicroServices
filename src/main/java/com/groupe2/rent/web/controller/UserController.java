package com.groupe2.rent.web.controller;
import com.groupe2.rent.dao.contract.UserDao;
import com.groupe2.rent.model.RentUser;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import java.util.List;

@RestController
@Api("API pour les operations CRUD sur les users.")

public class UserController {

    @Autowired
    private UserDao userDao;

    //    @ApiOperation(value = "Récupère une liste de tous les users")
//   @GetMapping("/users")
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<RentUser> findAll() {
        return userDao.findAll();
    }

    @GetMapping("/users/{id}")
    public RentUser show(@PathVariable int id) {
        return userDao.findById(id).orElse(null);
    }

    @PutMapping("/users/{id}")
    public String update() {
        return "user updated";
    }


    @PostMapping("/users/")
    public void create(@RequestBody RentUser user) {
        RestTemplate restTemplate = new RestTemplate();
        Boolean result = restTemplate.getForObject("http://localhost:8081/licenses/{id}", Boolean.class, user.getLicenceNumber());
        if (result) {
            userDao.save(user);
        }
    }

    @DeleteMapping("/users/{id}")
    public void delete(@PathVariable int id) {
        userDao.deleteById(id);
    }
}
