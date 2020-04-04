package com.marcosjlima.demoworkshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marcosjlima.demoworkshop.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
