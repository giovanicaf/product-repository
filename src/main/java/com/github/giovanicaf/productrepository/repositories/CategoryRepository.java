package com.github.giovanicaf.productrepository.repositories;

import com.github.giovanicaf.productrepository.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
