package com.colsubsidio.co.interfaces;

import java.util.List;

import com.colsubsidio.co.models.Cliente;

public interface ICliente {
	
	Cliente guardar(Cliente cliente);
	Cliente actualizar(Cliente cliente);
	void eliminar(Integer id);
	Cliente buscarPorId(Integer id);
	List<Cliente> listarClientes();
	

}
