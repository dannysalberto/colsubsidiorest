package com.colsubsidio.co.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.colsubsidio.co.models.Movimiento;

@Repository
public interface MovimientoRepository extends JpaRepository<Movimiento, Integer> {
	
	List<Movimiento> findByCuenta_Id(Integer id);
	
	@Query("SELECT sum(m.valor) FROM Movimiento m where m.cuenta.id = ?1")
	BigDecimal obtenerSaldo(Integer idCuenta);
	
}
