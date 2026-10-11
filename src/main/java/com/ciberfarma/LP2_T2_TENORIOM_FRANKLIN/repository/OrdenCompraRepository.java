package com.ciberfarma.LP2_T2_TENORIOM_FRANKLIN.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ciberfarma.LP2_T2_TENORIOM_FRANKLIN.model.OrdenCompraTF;

public interface OrdenCompraRepository extends JpaRepository<OrdenCompraTF, Integer> {

	List<OrdenCompraTF> findAllByOrderByNroOrdenDesc();
}
