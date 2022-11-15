package com.test.market.domain.repository;

import com.test.market.domain.Product;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface ProductRepository {

    //Definimos las reglas/objetos de dominio y desacoplamos la base de datos de la solución
    List<Product> getAll();
    Optional<List<Product>> getByCategory(int categoryId);
    Optional<List<Product>> getScarseProducts(int quantity);
    Optional<Product> getProduct(int productId);
    Product saveProduct(Product product);
    void delete(int productId);
}
