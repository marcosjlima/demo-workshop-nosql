package com.marcosjlima.demoworkshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marcosjlima.demoworkshop.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
