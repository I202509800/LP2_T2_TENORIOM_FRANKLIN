package com.ciberfarma.LP2_T2_TENORIOM_FRANKLIN.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ciberfarma.LP2_T2_TENORIOM_FRANKLIN.dto.ResultadoResponse;
import com.ciberfarma.LP2_T2_TENORIOM_FRANKLIN.model.OrdenCompraTF;
import com.ciberfarma.LP2_T2_TENORIOM_FRANKLIN.repository.OrdenCompraRepository;


import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrdenCompraService {
	
	private final OrdenCompraRepository ordenCompraRepository;
	
	public List<OrdenCompraTF> getAll() {
		return ordenCompraRepository.findAllByOrderByNroOrdenDesc();
		
	}
	
	
	@Transactional
	public ResultadoResponse create(OrdenCompraTF ordenCompra) {        /*17*/
		try {
			var registrado = ordenCompraRepository.save(ordenCompra);     /*17*/
			
			var mensaje = String.format("Orden de Compra con Numero %d registrada", registrado.getNroOrden());    
			
			return new ResultadoResponse(true, mensaje);    
			
		} catch (Exception e) {     
			e.printStackTrace();     
			return new ResultadoResponse(false, "Hubo un error en la transación");     
		}
		
	}
	
	public OrdenCompraTF getOne(Integer id) {
		return ordenCompraRepository.findById(id).orElse(null);
		
	}
	
	@Transactional
	public ResultadoResponse update(OrdenCompraTF ordenCompra) {        
		try {
			var registrado = ordenCompraRepository.save(ordenCompra);     
			
			var mensaje = String.format("Orden de Compra con Numero %d Actualizada", registrado.getNroOrden());    
			
			return new ResultadoResponse(true, mensaje);    
			
		} catch (Exception e) {     
			e.printStackTrace();     
			return new ResultadoResponse(false, "Hubo un error en la transación");     
		}
		
	}

}
