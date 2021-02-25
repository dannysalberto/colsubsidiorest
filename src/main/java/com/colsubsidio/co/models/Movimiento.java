package com.colsubsidio.co.models;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;

@Entity
@Table(name="movimiento")
public class Movimiento {
	
	@Id
	@NotNull
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull
	@Column(name="tipo", nullable=false, columnDefinition="INTEGER NOT NULL" , length=1)
	private Integer tipo;
	
	@NotNull
	@Column(name="fecha", nullable=false)
	private Date fecha;
	
	@NotNull
	@Column(name="valor", nullable=false, columnDefinition="NUMERIC(20,6) NOT NULL")
	private BigDecimal valor;

	@NotNull
	@JsonBackReference
	@JoinColumn(name = "cuenta_id", nullable = false)
	@ManyToOne(fetch = FetchType.EAGER)
	private Cuenta cuenta;
	
	@Transient
	private BigDecimal saldo;
	

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

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", locale = "es_CO")
	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Cuenta getCuenta() {
		return cuenta;
	}

	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}
	
	public BigDecimal getSaldo() {
		return saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

	@Override
	public String toString() {
		return "Movimiento [id=" + id + ", tipo=" + tipo + ", fecha=" + fecha + ", valor=" + valor + ", cuenta="
				+ cuenta + ", saldo=" + saldo + "]";
	}

	
	

}
