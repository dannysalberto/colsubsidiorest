package com.colsubsidio.co.request;

import java.math.BigDecimal;

import javax.validation.constraints.NotEmpty;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;

@ApiOperation("Modelo cuenta bancaria")
public class CuentaRequest {
	
	private Integer id;
	
	@NotEmpty
	@ApiModelProperty(value = "id del cliente titular de la cuenta", required = true)
	private Integer cliente_id;

	@NotEmpty
	@ApiModelProperty(value = "Número de la cuenta bancaria", required = true)
	private String numero;

	@NotEmpty
	@ApiModelProperty(value = "Saldo de la cuenta", required = true)
	private BigDecimal saldo;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCliente_id() {
		return cliente_id;
	}

	public void setCliente_id(Integer cliente_id) {
		this.cliente_id = cliente_id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}


}
