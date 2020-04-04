package com.marcosjlima.demoworkshop.services;

import java.security.InvalidParameterException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcosjlima.demoworkshop.entities.Order;
import com.marcosjlima.demoworkshop.repositories.OrderRepository;

@Service
public class OrderService {
	@Autowired
	private OrderRepository orderRepository; 
	
	public List<Order> findAll(){
		return orderRepository.findAll();
	}

	public Order findById(Long id){
		return orderRepository.findById(id).orElseThrow(() -> new InvalidParameterException("id não encotrado!"));
	}
}
