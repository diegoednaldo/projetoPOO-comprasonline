package com.comprasonline.projectPOO.servicies;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.comprasonline.projectPOO.entities.Product;
import com.comprasonline.projectPOO.entities.User;
import com.comprasonline.projectPOO.repositories.ProductRepository;
import com.comprasonline.projectPOO.servicies.exceptions.DatabaseException;
import com.comprasonline.projectPOO.servicies.exceptions.ResourceNotFoundException;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;
	
	//Listar todos do repositorios user
	public List<Product> findAll(){
		return repository.findAll();
	}
	
	public Product findById(Long id) {
		
		Optional<Product> obj = repository.findById(id);
		return obj.get();
	}
	public Product insert(Product obj) {
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
}

