package com.comprasonline.projectPOO.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.comprasonline.projectPOO.entities.Order;
import com.comprasonline.projectPOO.entities.User;
import com.comprasonline.projectPOO.servicies.OrderService;


@RestController
@RequestMapping(value = "/orders")
public class OrderResource {

	@Autowired
	private OrderService service;
	//ResponseEmtity respostas de requisições web
	//Método que responde ao get do http
	//Temo sum controlador rest que responde no caminho users
	@GetMapping
	public ResponseEntity<List<Order>> findAll(){		
		List<Order> list = service.findAll();
		//ok = retornar resposta com sucesso no http ; body= corpo da resposta
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Order> findById(@PathVariable Long id){
		Order obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	//inserir
		@PostMapping
		public ResponseEntity<Order> insert(@RequestBody Order obj){
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
		//Atualizar
		@PutMapping(value = "/{id}")
		public ResponseEntity<Order> update(@PathVariable Long id, @RequestBody Order updatedOrder) {
		    Order obj = service.findById(id);
		    obj.setMoment(updatedOrder.getMoment());
		    obj.setOrderStatus(updatedOrder.getOrderStatus());
		    obj.setClient(updatedOrder.getClient());
		    obj.setPayment(updatedOrder.getPayment());

		    Order updatedObj = service.update(obj);
		    return ResponseEntity.ok().body(updatedObj);
		}

}
