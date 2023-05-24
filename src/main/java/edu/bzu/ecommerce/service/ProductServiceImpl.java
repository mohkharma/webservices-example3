package edu.bzu.ecommerce.service;

import edu.bzu.ecommerce.exception.ResourceNotFoundException;
import edu.bzu.ecommerce.model.Product;
import edu.bzu.ecommerce.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Iterable<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProduct(long id) {
        return productRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product update(Long id, Product productDTO) {
        Optional<Product> product = productRepository.findById(id);

        product.get().setPrice(productDTO.getPrice());
        product.get().setName(productDTO.getName());
        product.get().setPictureUrl(productDTO.getPictureUrl());

        Product result = productRepository.save(product.get());
        //todo you should use mappers to spperate the DTO and entities usage.
        return result;
    }
}
