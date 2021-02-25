package com.colsubsidio.co.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.colsubsidio.co.models.Cuenta;

@Repository
public interface CuentaRepository extends JpaRepository<Cuenta, Integer> {

	List<Cuenta> findByCliente_Id(Integer id);
}
