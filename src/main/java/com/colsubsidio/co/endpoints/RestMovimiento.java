package com.colsubsidio.co.endpoints;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.colsubsidio.co.config.Constantes;
import com.colsubsidio.co.config.ResponseGeneric;
import com.colsubsidio.co.models.Cuenta;
import com.colsubsidio.co.models.Movimiento;
import com.colsubsidio.co.request.MovimientoRequest;
import com.colsubsidio.co.services.CuentaService;
import com.colsubsidio.co.services.MovimientoService;

@RestController
@RequestMapping(value="movimiento")
@CrossOrigin(origins="*")
public class RestMovimiento {

	@Autowired
	MovimientoService serviceMovimiento;
	
	@Autowired
	CuentaService serviceCuenta;
	
	@GetMapping(value="/{id}")
	public ResponseEntity<?> obtenerMovimiento(@PathVariable("id") Integer id){
		
		Movimiento movimiento = serviceMovimiento.buscarPorId(id);

		if (movimiento !=null) {
			return new ResponseEntity<Movimiento>(movimiento,HttpStatus.OK);								
		}else {
			// TODO: handle exception
			ResponseGeneric response = new ResponseGeneric();
			response.setStatus(false);
			response.setMessage(Constantes.NO_EXISTE);
			return new ResponseEntity<ResponseGeneric>(response,HttpStatus.NOT_FOUND);
		}	
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<?> borrarMovimiento(@PathVariable("id") Integer id){
		
		try {
			serviceMovimiento.eliminar(id);
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
	public ResponseEntity<?> guardar(@RequestBody MovimientoRequest movimientoRequest){
		
		Movimiento movimiento = new Movimiento();
		
		Cuenta cuenta= serviceCuenta.buscarPorId(movimientoRequest.getCuenta_id());
		if (cuenta!=null) {
			movimiento.setCuenta(cuenta); 
		}else {
			System.out.println("No existe la cuenta");
		}
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

		try {
			movimiento.setFecha(format.parse(movimientoRequest.getFecha()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		movimiento.setTipo(movimientoRequest.getTipo());
		if (movimientoRequest.getTipo()==Constantes.DEBITO) {
			movimiento.setValor(movimientoRequest.getValor().multiply(new BigDecimal(-1)));
		}else {
			movimiento.setValor(movimientoRequest.getValor());			
		}
		movimiento = serviceMovimiento.guardar(movimiento);
		/*se requiere que en cada response despues de guardar un movimiento, se retorne el saldo de la
		 * cuenta por lo tanto se le agrega un atributo transient y aquí registramos el saldo para 
		 * el response*/
		movimiento.setSaldo(serviceMovimiento.saldoCuentaPorId(movimiento.getCuenta().getId()));
		cuenta.setSaldo(movimiento.getSaldo());
		serviceCuenta.actualizar(cuenta);
		
		return new ResponseEntity<Movimiento>(movimiento, HttpStatus.OK);
		
	}
	
	//@PutMapping
	public ResponseEntity<?> actualizar(@RequestBody MovimientoRequest movimientoRequest){
		
		Movimiento movimiento;
		movimiento = serviceMovimiento.buscarPorId(movimientoRequest.getId());
		if (movimiento!=null) {
			
			Cuenta cuenta= serviceCuenta.buscarPorId(movimientoRequest.getCuenta_id());
			if (cuenta!=null) {
				movimiento.setCuenta(cuenta); 
			}else {
				System.out.println("No existe la cuenta");
			}
			
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			try {
				movimiento.setFecha(format.parse(movimientoRequest.getFecha()));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			movimiento.setTipo(movimientoRequest.getTipo());
			movimiento.setValor(movimientoRequest.getValor());
			return new ResponseEntity<Movimiento>(serviceMovimiento.actualizar(movimiento), HttpStatus.OK);

		}else {
			ResponseGeneric response = new ResponseGeneric();
			response.setStatus(false);
			response.setMessage(Constantes.NO_EXISTE);
			return new ResponseEntity<ResponseGeneric>(response,HttpStatus.NOT_FOUND);
		}
	}
}
