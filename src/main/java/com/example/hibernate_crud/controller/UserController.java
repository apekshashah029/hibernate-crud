package com.example.hibernate_crud.controller;


import com.example.hibernate_crud.entity.User;
import com.example.hibernate_crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.autoconfigure.WebMvcProperties;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable Long id){
        return userService.findUserById(id);
    }

    @GetMapping("/")
    public List<User> getUsers(){
        return userService.getAllUsers();
    }

    @PostMapping("/")
    public User saveUser(@RequestBody User user){
        return userService.saveUser(user);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable  Long id,@RequestBody User user){
        return userService.updateUser(id,user);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id){
        return userService.deleteById(id);
    }

    @GetMapping("/high-total-quantity")
    public List<Object[]> findUsersWithHighTotalQuantity(){
        return userService.findUsersWithHighTotalQuantity();
    }

    @GetMapping("/with-products")
    public List<User> findUsersWithProducts(){
        return userService.findUsersWithProducts();
    }

}
