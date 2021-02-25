package com.colsubsidio.co.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.colsubsidio.co.interfaces.IReporte;
import com.colsubsidio.co.models.Reporte;
import com.colsubsidio.co.repository.ReporteRepository;

@Service
public class ReporteService implements IReporte{

	@Autowired
	ReporteRepository repo;
	
	@Override
	public List<Reporte> reporteClientePorFecha(Integer idCliente, Date fechaDesde, Date fechaHasta) {
		// TODO Auto-generated method stub
		return repo.findByIdclienteAndFechaBetween(idCliente, fechaDesde, fechaHasta);
	}

}
