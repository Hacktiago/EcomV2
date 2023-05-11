package com.ecommerce.back;

import org.junit.jupiter.api.Test;

import com.ecommerce.back.security.entities.User;
import com.ecommerce.back.entities.Sale;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class SaleTest {

    private Sale sale;

    @BeforeEach
    void setUp() {
        User client = new User("JohnDoe", "johndoe@example.com", "password123");
        sale = new Sale(100.0, new Date(), client);
    }

    @AfterEach
    void tearDown() {
        sale = null;
    }

    @Test
    void testGetId() {
        assertNull(sale.getId());
    }

    @Test
    void testSetId() {
        String id = "12345";
        sale.setId(id);
        assertEquals(id, sale.getId());
    }

    @Test
    void testGetTotal() {
        assertEquals(100.0, sale.getTotal());
    }

    @Test
    void testSetTotal() {
        double newTotal = 200.0;
        sale.setTotal(newTotal);
        assertEquals(newTotal, sale.getTotal());
    }

    @Test
    void testGetDate() {
        assertNotNull(sale.getDate());
    }

    @Test
    void testSetDate() {
        Date newDate = new Date();
        sale.setDate(newDate);
        assertEquals(newDate, sale.getDate());
    }

    @Test
    void testGetClient() {
        assertNotNull(sale.getClient());
    }

    @Test
    void testSetClient() {
        User newClient = new User("JaneDoe", "janedoe@example.com", "password123");
        sale.setClient(newClient);
        assertEquals(newClient, sale.getClient());
    }

}