package com.example.hibernate_crud;

import com.example.hibernate_crud.entity.User;
import com.example.hibernate_crud.repository.UserRepository;
import com.example.hibernate_crud.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@SpringBootTest
class UserServiceTest {

    @Autowired
    private UserService userService;

    @MockitoBean
    private UserRepository userRepo;

    @Test
    void saveUserTest() {
        User user = new User();
        user.setName("Dhriti");
        user.setAge(10);

        when(userRepo.save(user)).thenReturn(user);

        User savedUser = userService.saveUser(user);

        assertNotNull(savedUser);
        assertEquals("Ruchita", savedUser.getName());
    }
}

