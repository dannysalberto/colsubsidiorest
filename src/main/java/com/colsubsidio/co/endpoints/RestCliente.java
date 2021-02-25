package com.colsubsidio.co.endpoints;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.colsubsidio.co.config.Constantes;
import com.colsubsidio.co.config.ResponseGeneric;
import com.colsubsidio.co.models.Cliente;
import com.colsubsidio.co.request.ClienteRequest;
import com.colsubsidio.co.services.ClienteService;

@RestController
@RequestMapping(value="cliente")
@CrossOrigin(origins="*")
public class RestCliente {
	
	@Autowired
	ClienteService serviceCliente;
	
	@GetMapping(value="/list")
	public ResponseEntity<?> listarCliente(){
		
		List<Cliente> lista;  
		lista = serviceCliente.listarClientes();
		if (lista!=null) {
			return new ResponseEntity<List<Cliente>>(lista,HttpStatus.OK);
		}
		ResponseGeneric response = new ResponseGeneric();
		response.setStatus(false);
		response.setMessage(Constantes.NO_EXISTE);
		return new ResponseEntity<ResponseGeneric>(response,HttpStatus.NOT_FOUND);
			
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<?> obtenerCliente(@PathVariable("id") Integer id){
		
		Cliente cliente = serviceCliente.buscarPorId(id);
		if (cliente!=null) {
			return new ResponseEntity<Cliente>(cliente,HttpStatus.OK);	
		}else {
			ResponseGeneric response = new ResponseGeneric();
			response.setStatus(false);
			response.setMessage(Constantes.NO_EXISTE);
			return new ResponseEntity<ResponseGeneric>(response,HttpStatus.NOT_FOUND);	
		}
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<?> borrarCliente(@PathVariable("id") Integer id){
		
		try {
			serviceCliente.eliminar(id);
			ResponseGeneric response = new ResponseGeneric();
			response.setStatus(false);
			response.setMessage(Constantes.ELIMINADO);
			return new ResponseEntity<ResponseGeneric>(response,HttpStatus.ACCEPTED);

		}catch (Exception e) {
			ResponseGeneric response = new ResponseGeneric();
			response.setStatus(false);
			response.setMessage(Constantes.NO_EXISTE);
			return new ResponseEntity<ResponseGeneric>(response,HttpStatus.NOT_FOUND);
		}    
	}
	
	@PostMapping
	public ResponseEntity<?> guardar(@RequestBody ClienteRequest clienteRequest){
		
		Cliente cliente = new Cliente();
		
		cliente.setDireccion(clienteRequest.getDireccion());
		cliente.setNombre(clienteRequest.getNombre());
		cliente.setTelefono(clienteRequest.getTelefono());
		return new ResponseEntity<Cliente>(serviceCliente.guardar(cliente), HttpStatus.OK);	
			 
	}
	
	@PutMapping
	public ResponseEntity<?> actualizar(@RequestBody ClienteRequest clienteRequest){
		
		Cliente cliente = serviceCliente.buscarPorId(clienteRequest.getId());
		if (cliente!=null) {
			cliente.setDireccion(clienteRequest.getDireccion());
			cliente.setNombre(clienteRequest.getNombre());
			cliente.setTelefono(clienteRequest.getTelefono());
			return new ResponseEntity<Cliente>(serviceCliente.actualizar(cliente), HttpStatus.OK);	
		}else {
			ResponseGeneric response = new ResponseGeneric();
			response.setStatus(false);
			response.setMessage(Constantes.NO_EXISTE);
			return new ResponseEntity<ResponseGeneric>(response,HttpStatus.NOT_FOUND);
		}
	}

}
