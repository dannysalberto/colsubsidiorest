package com.colsubsidio.co.endpoints;

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
import com.colsubsidio.co.models.Cuenta;
import com.colsubsidio.co.request.CuentaRequest;
import com.colsubsidio.co.services.ClienteService;
import com.colsubsidio.co.services.CuentaService;

@RestController
@RequestMapping(value="cuenta")
@CrossOrigin(origins="*")
public class RestCuenta {

	@Autowired
	CuentaService serviceCuenta;
	
	@Autowired
	ClienteService serviceCliente;
	
	@GetMapping(value="/{id}")
	public ResponseEntity<?> obtenerCuenta(@PathVariable("id") Integer id){
		
		Cuenta cuenta = serviceCuenta.buscarPorId(id);

		if (cuenta!=null) {
			return new ResponseEntity<Cuenta>(cuenta,HttpStatus.OK);								
		}else {
			// TODO: handle exception
			ResponseGeneric response = new ResponseGeneric();
			response.setStatus(false);
			response.setMessage(Constantes.NO_EXISTE);
			return new ResponseEntity<ResponseGeneric>(response,HttpStatus.NOT_FOUND);
		}	
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<?> borrarCuenta(@PathVariable("id") Integer id){
		
		try {
			serviceCuenta.eliminar(id);
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
	public ResponseEntity<?> guardar(@RequestBody CuentaRequest cuentaRequest){
		
		Cuenta cuenta = new Cuenta();
		
		Cliente cliente = serviceCliente.buscarPorId(cuentaRequest.getCliente_id());
		if (cliente!=null) {
			cuenta.setCliente(cliente); 
		}else {
			System.out.println("No existe cliente");
		}
		cuenta.setNumero(cuentaRequest.getNumero());
		cuenta.setSaldo(cuentaRequest.getSaldo());
		return new ResponseEntity<Cuenta>(serviceCuenta.guardar(cuenta), HttpStatus.OK);
		
	}
	
	@PutMapping
	public ResponseEntity<?> actualizar(@RequestBody CuentaRequest cuentaRequest){
		
		Cuenta cuenta = new Cuenta();
		cuenta = serviceCuenta.buscarPorId(cuentaRequest.getId());
		if (cuenta != null) {
			Cliente cliente = new Cliente();
			cliente = serviceCliente.buscarPorId(cuentaRequest.getCliente_id());
			if (cliente!=null) {
				cuenta.setCliente(cliente);
			}else {
				ResponseGeneric response = new ResponseGeneric();
				response.setStatus(false);
				response.setMessage(Constantes.NO_EXISTE);
				return new ResponseEntity<ResponseGeneric>(response,HttpStatus.NOT_FOUND);
			}
			cuenta.setNumero(cuentaRequest.getNumero());
			cuenta.setSaldo(cuentaRequest.getSaldo());
			return new ResponseEntity<Cuenta>(serviceCuenta.actualizar(cuenta), HttpStatus.OK);

			
		}else {
			ResponseGeneric response = new ResponseGeneric();
			response.setStatus(false);
			response.setMessage(Constantes.NO_EXISTE);
			return new ResponseEntity<ResponseGeneric>(response,HttpStatus.NOT_FOUND);
		}
	}
}
