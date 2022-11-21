package com.prog.den.service;

import com.prog.den.model.Product;
import com.prog.den.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepository productRepository;

    public Product save(Product e) {
        return productRepository.save(e);
    }

    public List<Product> list() {
        return productRepository.findAll();
    }
}
