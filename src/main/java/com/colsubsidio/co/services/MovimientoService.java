package com.colsubsidio.co.services;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.colsubsidio.co.interfaces.IMovimiento;
import com.colsubsidio.co.models.Movimiento;
import com.colsubsidio.co.repository.MovimientoRepository;

@Service
public class MovimientoService implements IMovimiento{
	
	@Autowired
	MovimientoRepository repo;

	@Override
	public Movimiento guardar(Movimiento movimiento) {
		// TODO Auto-generated method stub
		return repo.save(movimiento);
		
	}

	@Override
	public Movimiento actualizar(Movimiento movimiento) {
		// TODO Auto-generated method stub
		return repo.save(movimiento);
		
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
		
	}

	@Override
	public List<Movimiento> listarMovimientoxCuenta(Integer id) {
		// TODO Auto-generated method stub
		return repo.findByCuenta_Id(id);
	}

	@Override
	public Movimiento buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		try {
			return repo.findById(id).get();
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			return null;
		}
	}

	@Override
	public BigDecimal saldoCuentaPorId(Integer idCuenta) {
		// TODO Auto-generated method stub
		return repo.obtenerSaldo(idCuenta);
	}
	
	

}
