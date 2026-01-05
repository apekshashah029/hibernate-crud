package com.example.hibernate_crud;

import com.example.hibernate_crud.controller.UserController;
import com.example.hibernate_crud.entity.User;
import com.example.hibernate_crud.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@SpringBootTest
class UserControllerTest {

    @Autowired
    private UserController userController;

    @MockitoBean
    private UserService userService;

    @Test
    void createUser_directCall() {

        User user = new User();
        user.setName("Arshii");
        user.setAge(28);

        when(userService.saveUser(any(User.class)))
                .thenReturn(user);

        User response = userController.saveUser(user);

        assertNotNull(response);
        assertEquals("Arshii", response.getName());
        assertEquals(28, response.getAge());
    }
}
