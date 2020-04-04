package com.marcosjlima.demoworkshop.services;

import java.security.InvalidParameterException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcosjlima.demoworkshop.entities.Product;
import com.marcosjlima.demoworkshop.repositories.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository ProductRepository; 
	
	public List<Product> findAll(){
		return ProductRepository.findAll();
	}
	
	public Product findById(Long id){
		return ProductRepository.findById(id).orElseThrow(() -> new InvalidParameterException("id não encotrado!"));
	}
}
