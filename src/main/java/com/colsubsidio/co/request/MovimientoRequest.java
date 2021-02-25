package com.colsubsidio.co.request;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotEmpty;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;

@ApiOperation("Modelo movimientos de cuenta")
public class MovimientoRequest {
	
	private Integer id;
	
	@NotEmpty
	@ApiModelProperty(value = "Tipo de movimiento bancario", required = true)
	private Integer tipo;
	
	@NotEmpty
	@ApiModelProperty(value = "Fecha del movimiento bancario", required = true)
	private String fecha;
	
	@NotEmpty
	@ApiModelProperty(value = "Monto o valor del movimiento bancario", required = true)
	private BigDecimal valor;

	@NotEmpty
	@ApiModelProperty(value = "Id de la cuenta a la que afecta el movimiento", required = true)
	private Integer cuenta_id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getTipo() {
		return tipo;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Integer getCuenta_id() {
		return cuenta_id;
	}

	public void setCuenta_id(Integer cuenta_id) {
		this.cuenta_id = cuenta_id;
	}


}
