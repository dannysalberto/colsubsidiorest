package com.colsubsidio.co.request;

import javax.validation.constraints.NotEmpty;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;

@ApiOperation("Modelo cliente")
public class ClienteRequest {

	private Integer id;
	
	@NotEmpty
	@ApiModelProperty(value = "Nombre del cliente titular de la cuenta", required = true)
	private String nombre;
	
	@NotEmpty
	@ApiModelProperty(value = "Dirección del cliente titular de la cuenta", required = true)
	private String direccion;
	
	@NotEmpty
	@ApiModelProperty(value = "Teléfono del cliente", required = true)
	private String telefono;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	
}
