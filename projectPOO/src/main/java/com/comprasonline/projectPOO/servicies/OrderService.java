package com.comprasonline.projectPOO.servicies;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.comprasonline.projectPOO.entities.Order;
import com.comprasonline.projectPOO.entities.User;
import com.comprasonline.projectPOO.repositories.OrderRepository;
import com.comprasonline.projectPOO.servicies.exceptions.DatabaseException;
import com.comprasonline.projectPOO.servicies.exceptions.ResourceNotFoundException;

@Service
public class OrderService {

	@Autowired
	private OrderRepository repository;
	
	//Listar todos do repositorios user
	public List<Order> findAll(){
		return repository.findAll();
	}
	
	public Order findById(Long id) {
		
		Optional<Order> obj = repository.findById(id);
		return obj.get();
	}
	public Order insert(Order obj) {
		return repository.save(obj);
	}

	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	public Order update(Order obj) {
	    return repository.save(obj);
	}


}

