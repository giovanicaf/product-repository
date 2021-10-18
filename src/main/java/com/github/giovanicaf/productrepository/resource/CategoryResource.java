package com.github.giovanicaf.productrepository.resource;

import com.github.giovanicaf.productrepository.entities.Category;
import com.github.giovanicaf.productrepository.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {

    @Autowired
    private CategoryRepository category;


    @PostMapping
    public void saveCategory(@RequestBody  Category cat){
        category.save( cat );
    }

    @GetMapping
    public ResponseEntity<List<Category>> findAll() {

        List<Category> list = category.findAll() ;
        return ResponseEntity.ok().body( list );
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Category> findById(@PathVariable Long id) {

        Category cat = category.findById(id).get() ;
        return ResponseEntity.ok( ).body( cat  );
    }
}