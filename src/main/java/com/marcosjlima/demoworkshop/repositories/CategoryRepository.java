package com.marcosjlima.demoworkshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marcosjlima.demoworkshop.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
