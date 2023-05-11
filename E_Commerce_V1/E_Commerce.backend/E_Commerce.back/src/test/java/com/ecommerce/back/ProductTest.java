package com.ecommerce.back;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.ecommerce.back.entities.Product;
import com.ecommerce.back.repositories.ProductRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class ProductTest {

	@Autowired
	private ProductRepository productRepository;
	
	@Test
	@Rollback(false)
	public void testGuardarProducto() {
		Product product = new Product("Celular Test", 7000000, "Celular smartphone de excelentes caracteristicas", "Celulares", "url-image");
		Product productSave = productRepository.save(product);
		
		assertNotNull(productSave);//
	}
	
}
