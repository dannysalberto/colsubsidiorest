package com.colsubsidio.co.interfaces;

import java.util.List;

import com.colsubsidio.co.models.Cuenta;

public interface ICuenta {

	Cuenta guardar(Cuenta cuenta);
	Cuenta actualizar(Cuenta cuenta);
	void eliminar(Integer id);
	Cuenta buscarPorId(Integer id);
	List<Cuenta> listarCuentaxCliente(Integer id);
	
}
