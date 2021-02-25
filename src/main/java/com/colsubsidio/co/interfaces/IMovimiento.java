package com.colsubsidio.co.interfaces;

import java.math.BigDecimal;
import java.util.List;

import com.colsubsidio.co.models.Movimiento;

public interface IMovimiento {

	Movimiento guardar(Movimiento movimiento);
	Movimiento actualizar(Movimiento movimiento);
	void eliminar(Integer id);
	Movimiento buscarPorId(Integer id);
	BigDecimal saldoCuentaPorId(Integer idCuenta);
	List<Movimiento> listarMovimientoxCuenta(Integer id);
}
