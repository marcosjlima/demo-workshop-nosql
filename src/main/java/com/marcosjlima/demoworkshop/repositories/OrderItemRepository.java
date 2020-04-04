package com.marcosjlima.demoworkshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marcosjlima.demoworkshop.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
