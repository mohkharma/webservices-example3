package edu.bzu.ecommerce.service;

import edu.bzu.ecommerce.model.Product;
import jakarta.validation.constraints.Min;
import org.springframework.validation.annotation.Validated;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;


@Validated
public interface ProductService {

    @NotNull Iterable<Product> getAllProducts();

    Product getProduct(@Min(value = 1L, message = "Invalid product ID.") long id);

    Product save(Product product);

    Product update(Long id, Product product);
}
