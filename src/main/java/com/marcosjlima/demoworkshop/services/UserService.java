package com.marcosjlima.demoworkshop.services;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.marcosjlima.demoworkshop.entities.User;
import com.marcosjlima.demoworkshop.exceptions.DataBaseException;
import com.marcosjlima.demoworkshop.exceptions.ResourceNotFoundException;
import com.marcosjlima.demoworkshop.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	public List<User> findAll() {
		return userRepository.findAll();
	}

	public User findById(Long id) {
		return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public User Insert(User user) {
		return userRepository.save(user);
	}

	public void Delete(Long id) {
		try {
			userRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataBaseException(e.getMessage());
		}
	}

	public User Update(User user) {
		try {
			User entity = userRepository.getOne(user.getId());

			entity.setEmail(user.getEmail());
			entity.setName(user.getName());
			entity.setPhone(user.getPhone());
			entity.setPassword(user.getPassword());

			return userRepository.save(entity);
			
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(user.getId());
		}
	}
}
