package com.colsubsidio.co.interfaces;

import java.util.Date;
import java.util.List;

import com.colsubsidio.co.models.Reporte;

public interface IReporte {

	List<Reporte> reporteClientePorFecha(Integer idCliente,Date fechaDesde,Date fechaHasta);
}
