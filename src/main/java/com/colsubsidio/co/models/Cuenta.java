package com.colsubsidio.co.models;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.istack.NotNull;

@Entity
@Table(name="cuenta")
public class Cuenta {
	
	@Id
	@NotNull
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull
	@JsonBackReference
	@JoinColumn(name = "cliente_id", nullable = false)
	@ManyToOne(fetch = FetchType.EAGER)
	private Cliente cliente;
	
	@NotNull
	@Column(name="numero", nullable=false , columnDefinition="varchar(20) NOT NULL" , length=20)
	private String numero;
	
	@NotNull
	@Column(name="saldo", nullable=false , columnDefinition="NUMERIC(20,6) NOT NULL")
	private BigDecimal saldo;
	
	@JsonManagedReference
	@OneToMany(mappedBy="cuenta",cascade=CascadeType.REMOVE)
	private List<Movimiento> movimiento;
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
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
	
		public List<Movimiento> getMovimiento() {
		return movimiento;
	}

	public void setMovimiento(List<Movimiento> movimiento) {
		this.movimiento = movimiento;
	}

	@Override
	public String toString() {
		return "Cuenta [id=" + id + ", cliente=" + cliente + ", numero=" + numero + ", saldo=" + saldo + ", movimiento="
				+ movimiento + "]";
	}
	

}
