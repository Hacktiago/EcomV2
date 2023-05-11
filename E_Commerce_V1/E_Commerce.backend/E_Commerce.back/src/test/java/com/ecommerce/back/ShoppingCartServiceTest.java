package com.ecommerce.back;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.ecommerce.back.entities.ShoppingCart;
import com.ecommerce.back.repositories.ShoppingCartRepository;
import com.ecommerce.back.services.ShoppingCartService;

import static org.assertj.core.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class ShoppingCartServiceTest {

    @Mock
    private ShoppingCartRepository shoppingCartRepository;

    @InjectMocks
    private ShoppingCartService shoppingCartService;

    @Test
    public void testGetListByClient() {
        // Given
        String userName = "testuser";
        List<ShoppingCart> expectedList = new ArrayList<>();
        expectedList.add(new ShoppingCart());

        when(shoppingCartRepository.findByClient_UserName(userName)).thenReturn(expectedList);

        // When
        List<ShoppingCart> actualList = shoppingCartService.getListByClient(userName);

        // Then
        verify(shoppingCartRepository).findByClient_UserName(userName);
        assertThat(actualList).isEqualTo(expectedList);
    }

}
