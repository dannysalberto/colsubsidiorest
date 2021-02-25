package com.colsubsidio.co.endpoints;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.colsubsidio.co.models.Reporte;
import com.colsubsidio.co.request.ReporteClienteRequest;
import com.colsubsidio.co.services.ReporteService;

@RestController
@RequestMapping(value="cliente")
@CrossOrigin(origins="*")
public class RestReporte {
	
	@Autowired
	ReporteService serviceReporte;
	
	@PostMapping(value="/reporte")
	public ResponseEntity<?> reporteClienteMovimiento(@RequestBody ReporteClienteRequest report){
		
		List<Reporte> lista;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		
		Date fechaDesde = null;
		try {
			fechaDesde = format.parse(report.getFechaDesde());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Date fechaHasta = null;
		try {
			fechaHasta = format.parse(report.getFechaHasta());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		lista = serviceReporte.reporteClientePorFecha(report.getCliente_id(), fechaDesde, fechaHasta);
		if (lista!=null) {
			return new ResponseEntity<List<Reporte>>(lista,HttpStatus.OK);
		}
		return null;
			
	}
	
	
}
