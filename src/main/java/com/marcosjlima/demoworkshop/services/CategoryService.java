package com.marcosjlima.demoworkshop.services;

import java.security.InvalidParameterException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcosjlima.demoworkshop.entities.Category;
import com.marcosjlima.demoworkshop.repositories.CategoryRepository;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepository CategoryRepository; 
	
	public List<Category> findAll(){
		return CategoryRepository.findAll();
	}
	
	public Category findById(Long id){
		return CategoryRepository.findById(id).orElseThrow(() -> new InvalidParameterException("id não encotrado!"));
	}
}
