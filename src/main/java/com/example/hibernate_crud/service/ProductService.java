package com.example.hibernate_crud.service;

import com.example.hibernate_crud.entity.Product;
import com.example.hibernate_crud.entity.User;
import com.example.hibernate_crud.repository.ProductRepository;
import com.example.hibernate_crud.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    public ProductService(ProductRepository productRepository,
                          UserRepository userRepository) {
        this.productRepository = productRepository;
        this.userRepository = userRepository;
    }

    public Product findProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    @Transactional
    public Product createProduct(Product product) {

        return productRepository.save(product);
    }

    @Transactional
    public Product attachProductToUser(Long productId, Long userId) {

        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        product.setUser(user);
        return product;
    }

    @Transactional
    public Product updateProduct(Long id, Product product) {

        Product existingProduct = findProductById(id);

        existingProduct.setProductName(product.getProductName());
        existingProduct.setQuantity(product.getQuantity());

        return existingProduct;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public List<Product> getProductsByUser(Long userId) {
        return productRepository.findByUser_UId(userId);
    }

    public String deleteProduct(Long id) {

        Product product = findProductById(id);
        productRepository.delete(product);
        return "Product deleted successfully";
    }
}
