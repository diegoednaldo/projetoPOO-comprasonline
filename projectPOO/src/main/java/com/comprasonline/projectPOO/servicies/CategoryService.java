package com.comprasonline.projectPOO.servicies;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.comprasonline.projectPOO.entities.Category;
import com.comprasonline.projectPOO.entities.User;
import com.comprasonline.projectPOO.repositories.CategoryRepository;
import com.comprasonline.projectPOO.servicies.exceptions.DatabaseException;
import com.comprasonline.projectPOO.servicies.exceptions.ResourceNotFoundException;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository repository;
	
	//Listar todos do repositorios user
	public List<Category> findAll(){
		return repository.findAll();
	}
	
	public Category findById(Long id) {
		
		Optional<Category> obj = repository.findById(id);
		return obj.get();
	}
	public Category insert(Category obj) {
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

