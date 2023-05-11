package com.ecommerce.back;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.ecommerce.back.security.entities.User;
import com.ecommerce.back.security.repositories.UserRepository;

@SpringBootTest
@Transactional
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class UserCreateTest {

    @Autowired
    private UserRepository userRepository;

    @Test
	@Rollback(false)
    public void testCreateUser() {
        // Create a new user
        User user = new User();
        user.setUserName("Nuevo Usuario");
        user.setPassword("password2");
        user.setEmail("email@email.com");

        // Save the user to the database
        User savedUser = userRepository.save(user);

        // Verify that the user was saved correctly
        assertNotNull(savedUser.getId());
        assertEquals(user.getUserName(), savedUser.getUserName());
        assertEquals(user.getPassword(), savedUser.getPassword());
        assertEquals(user.getEmail(), savedUser.getEmail());
    }
}