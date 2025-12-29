package com.example.hibernate_crud.service;

import com.example.hibernate_crud.entity.Product;
import com.example.hibernate_crud.entity.User;
import com.example.hibernate_crud.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Transactional
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Transactional
    public User updateUser(Long id, User user) {

        User existingUser = findUserById(id);

        existingUser.setName(user.getName());
        existingUser.setAge(user.getAge());
        existingUser.setProducts(user.getProducts());

        return existingUser;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public String deleteById(Long id) {

        User user = findUserById(id);
        System.out.println(user.getName());

        for (Product p : user.getProducts()) {
            p.setUser(null);
        }

        userRepository.delete(user);
        return "User deleted successfully";
    }
}
