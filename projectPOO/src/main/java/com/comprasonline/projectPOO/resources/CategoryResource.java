package com.comprasonline.projectPOO.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.comprasonline.projectPOO.entities.Category;
import com.comprasonline.projectPOO.entities.User;
import com.comprasonline.projectPOO.servicies.CategoryService;


@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {

	@Autowired
	private CategoryService service;
	//ResponseEmtity respostas de requisições web
	//Método que responde ao get do http
	//Temo sum controlador rest que responde no caminho users
	@GetMapping
	public ResponseEntity<List<Category>> findAll(){		
		List<Category> list = service.findAll();
		//ok = retornar resposta com sucesso no http ; body= corpo da resposta
		return ResponseEntity.ok().body(list);
	}
	
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Category> findById(@PathVariable Long id){
		Category obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	//inserir
		@PostMapping
		public ResponseEntity<Category> insert(@RequestBody Category obj){
			obj = service.insert(obj);
			//retorna o comando 201, create
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
			return ResponseEntity.created(uri).body(obj);
		}
		
		//deletar
		@DeleteMapping(value = "/{id}")
		public ResponseEntity<Void> delete(@PathVariable Long id){
			service.delete(id);
			//Resposta vazia, código 204
			return ResponseEntity.noContent().build();
		}
		
}

