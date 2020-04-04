package com.marcosjlima.demoworkshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marcosjlima.demoworkshop.entities.Category;
import com.marcosjlima.demoworkshop.services.CategoryService;

@RestController
@RequestMapping(value = "/categories")
public class CategoryController {

	@Autowired
	CategoryService userService;

	@GetMapping()
	public ResponseEntity<List<Category>> findAll() {
		return ResponseEntity.ok().body(userService.findAll());
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Category> findById(@PathVariable Long id) {
		return ResponseEntity.ok().body(userService.findById(id));
	}
}