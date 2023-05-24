package edu.bzu.ecommerce.controller;

import edu.bzu.ecommerce.exception.ResourceNotFoundException;
import edu.bzu.ecommerce.model.Product;
import edu.bzu.ecommerce.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final Logger log = LoggerFactory.getLogger(ProductController.class);
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = {"", "/"})
    public Iterable<Product> getProducts() {
        return productService.getAllProducts();
    }


    @GetMapping("/{id}")
    public ResponseEntity<Product> getProducts(@PathVariable Long id) {
        Product product = productService.getProduct(id);
        return ResponseEntity.ok()
                .body(product);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@PathVariable Long id,
                                          @RequestBody Product product) {
        log.debug("REST request to update  : {}", product);
        try {
            Product result = productService.update(id, product);
            return ResponseEntity.ok()
                    .body(result);
        } catch (ResourceNotFoundException ex) {
            log.error("No resource with provided id exist : {}", id);
            throw new ResourceNotFoundException(ex.getMessage());
        }
    }

    @PostMapping("")
    public ResponseEntity<Product> create(@RequestBody Product product) {
        log.debug("REST request to create  : {}", product);
        try {
            Product result = productService.save(product);
            return ResponseEntity.created(new URI("/api/products/" + result.getId()))
                    .body(result);
        } catch (ResourceNotFoundException | URISyntaxException ex) {
//            log.error("No resource with provided id exist : {}", id);
            throw new ResourceNotFoundException(ex.getMessage());
        }
    }

}
