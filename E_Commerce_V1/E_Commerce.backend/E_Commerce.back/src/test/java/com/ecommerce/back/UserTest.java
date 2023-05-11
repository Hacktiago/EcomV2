package com.ecommerce.back;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.ecommerce.back.security.services.UserService;
import com.ecommerce.back.security.repositories.UserRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class UserTest {

	@Test
	public void testIsValidEmail() {
	    UserRepository userRepositoryMock = Mockito.mock(UserRepository.class);
	    UserService userService = new UserService(userRepositoryMock);

	    // Simular el comportamiento de existsByUserName
	    Mockito.when(userRepositoryMock.existsByUserName(Mockito.anyString()))
	           .thenReturn(Boolean.TRUE);

	    // Test a valid email address
	    assertTrue(userService.isValidEmail("test@example.com"));

	    // Test an invalid email address
	    assertFalse(userService.isValidEmail("invalid.email.address"));
	}

}
