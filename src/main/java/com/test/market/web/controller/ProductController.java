package com.test.market.web.controller;

import com.test.market.domain.Product;
import com.test.market.domain.service.ProductService;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products") //lleva como parámetro el path de la petición
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping()
    public List<Product> getAll(){
        return productService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Product> getProduct(@PathVariable("id") int productId){
        return productService.getProduct(productId);
    }

    @GetMapping("/category/{id}")
    public Optional<List<Product>> getByCategory(@PathVariable("id") int categoryId){
        return productService.getByCategory(categoryId);
    }

    @PostMapping("/save")
    public Product save(@RequestBody Product product){
        return productService.save(product);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") int productId){
        return productService.delete(productId);
    }
}