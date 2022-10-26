package com.example.anime_shop.service;

import com.example.anime_shop.model.Product;
import com.example.anime_shop.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProduct(){
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(long id){
        return productRepository.findById(id);
    }

    public void addProduct(Product product){
        productRepository.save(product);
    }

    public void deleteProductById(long id){
        productRepository.deleteById(id);
    }

    public List<Product> getAllProductByCategoryId(int id){
        return productRepository.findAllByCategoryId(id);
    }
}
