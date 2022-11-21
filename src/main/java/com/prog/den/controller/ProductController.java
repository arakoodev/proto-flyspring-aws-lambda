package com.prog.den.controller;

import com.prog.den.model.Product;
import com.prog.den.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/products")
@RestController
public class ProductController {

    private final ProductService productService;

    @PostMapping("")
    public Product create(@RequestBody Product r) {
        return productService.save(r);
    }

    @GetMapping("")
    public List<Product> list() {
        return productService.list();
    }
}
