package com.colsubsidio.co.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.colsubsidio.co.models.Reporte;

@Repository
public interface ReporteRepository extends JpaRepository<Reporte, Integer> {

	List<Reporte> findByIdclienteAndFechaBetween(Integer idCliente,Date fechaDesde,Date fechaHasta);
}
