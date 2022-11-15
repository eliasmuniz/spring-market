package com.test.market.persistence;

import com.test.market.domain.Product;
import com.test.market.domain.repository.ProductRepository;
import com.test.market.persistence.crud.ProductoCrudRepository;
import com.test.market.persistence.entity.Producto;
import com.test.market.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

// @Repository: Le indicamos a la clase que es la encarga de interactuar con la base de datos.
// también se puede usar @Component: le indicamos que es un componente de spring.
@Repository
public class ProductoRepository implements ProductRepository {

     // Con autowired se le da el control a sprin para la creación de objetos
    @Autowired
    private ProductoCrudRepository productoCrudRepository;
    @Autowired
    private ProductMapper mapper;

    //Definimos las reglas/objetos de dominio y desacoplamos la base de datos de la solución
    //List<Product> getAll();

    @Override
    public List<Product> getAll(){
        List<Producto> productos = (List<Producto>) productoCrudRepository.findAll();
        return mapper.toProducts(productos);
    }

    @Override
    public Optional<List<Product>> getByCategory(int categoryId){
        List<Producto> productos = productoCrudRepository.findByIdCategoriaOrderByNombreAsc(categoryId);
        return Optional.of( mapper.toProducts(productos));
    }

    @Override
    public Optional<List<Product>> getScarseProducts(int quantity){
        Optional<List<Producto>> productos = productoCrudRepository.findByCantidadStockLessThanAndEstado(quantity, true);
        return productos.map(prods -> mapper.toProducts(prods));
    }

    @Override
    public Optional<Product> getProduct(int productId){
        return productoCrudRepository.findById(productId).map(producto->mapper.toProduct(producto));
    }

    @Override
    public void delete(int productId){
        productoCrudRepository.deleteById(productId);
    }

    @Override
    public Product saveProduct(Product product){
        Producto producto = mapper.toProducto(product);
        return mapper.toProduct(productoCrudRepository.save(producto));
    }


}
