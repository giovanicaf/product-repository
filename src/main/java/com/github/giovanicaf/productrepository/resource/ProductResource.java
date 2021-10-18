package com.github.giovanicaf.productrepository.resource;

import com.github.giovanicaf.productrepository.entities.Product;
import com.github.giovanicaf.productrepository.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductResource {

    @Autowired
    private ProductRepository product;


    @PostMapping
    public void saveProduct(@RequestBody  Product cat){
        product.save( cat );
    }

    @GetMapping
    public ResponseEntity<List<Product>> findAll() {

        List<Product> list = product.findAll() ;
        return ResponseEntity.ok().body( list );
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id) {

        Product cat = product.findById(id) ;
        return ResponseEntity.ok( ).body( cat  );
    }
}