package com.example.hibernate_crud;


import com.example.hibernate_crud.entity.Product;
import com.example.hibernate_crud.entity.User;
import com.example.hibernate_crud.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
// by default entry will be rolled back
//@Rollback(value = false)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepo;

    @Test
    void findUser() {
        User user = new User();
        user.setName("Ruchita");
        user.setAge(19);

        User savedUser = userRepo.save(user);

        assertNotNull(savedUser);

    }
}

