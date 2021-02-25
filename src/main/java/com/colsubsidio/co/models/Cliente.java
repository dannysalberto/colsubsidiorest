package com.colsubsidio.co.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.istack.NotNull;

@Entity
@Table(name="cliente")
public class Cliente {

	@Id
	@NotNull
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull
	@Column(name="nombre", nullable=false , columnDefinition="varchar(30) NOT NULL" , length=30)
	private String nombre;
	
	@NotNull
	@Column(name="direccion", nullable=false , columnDefinition="varchar(50) NOT NULL" , length=50)
	private String direccion;
	
	@NotNull
	@Column(name="telefono", nullable=false , columnDefinition="varchar(12) NOT NULL" , length=12)
	private String telefono;
	
	@JsonManagedReference
	@OneToMany(mappedBy="cliente")
	private List<Cuenta> cuentas;

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

	public List<Cuenta> getCuentas() {
		return cuentas;
	}

	public void setCuentas(List<Cuenta> cuentas) {
		this.cuentas = cuentas;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nombre=" + nombre + ", direccion=" + direccion + ", telefono=" + telefono
				+ ", cuentas=" + cuentas + "]";
	}
	
	
	
	
}
