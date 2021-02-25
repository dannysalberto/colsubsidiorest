package com.colsubsidio.co.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.colsubsidio.co.interfaces.ICliente;
import com.colsubsidio.co.models.Cliente;
import com.colsubsidio.co.repository.ClienteRepository;

@Service
public class ClienteService implements ICliente{

	@Autowired
	ClienteRepository repo;
	
	@Override
	public Cliente guardar(Cliente cliente) {
		// TODO Auto-generated method stub
		return repo.save(cliente);
		
	}

	@Override
	public Cliente actualizar(Cliente cliente) {
		// TODO Auto-generated method stub
		return repo.save(cliente);
		
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
		
	}

	@Override
	public List<Cliente> listarClientes() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Cliente buscarPorId(Integer id) {
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
