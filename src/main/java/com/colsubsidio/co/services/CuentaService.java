
package com.colsubsidio.co.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.colsubsidio.co.interfaces.ICuenta;
import com.colsubsidio.co.models.Cuenta;
import com.colsubsidio.co.repository.CuentaRepository;

@Service
public class CuentaService implements ICuenta{

	
	@Autowired
	CuentaRepository repo;
	
	@Override
	public Cuenta guardar(Cuenta cuenta) {
		// TODO Auto-generated method stub
		return repo.save(cuenta);
		
	}

	@Override
	public Cuenta actualizar(Cuenta cuenta) {
		// TODO Auto-generated method stub
		return repo.save(cuenta);
		
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
		
	}

	@Override
	public List<Cuenta> listarCuentaxCliente(Integer id) {
		// TODO Auto-generated method stub
		return repo.findByCliente_Id(id);
	}

	@Override
	public Cuenta buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		try {
			return repo.findById(id).get();
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			return null;
		}
	}

}
