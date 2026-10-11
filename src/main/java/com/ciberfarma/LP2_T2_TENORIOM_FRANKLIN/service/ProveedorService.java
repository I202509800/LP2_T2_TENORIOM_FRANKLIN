package com.ciberfarma.LP2_T2_TENORIOM_FRANKLIN.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ciberfarma.LP2_T2_TENORIOM_FRANKLIN.model.ProveedorTF;
import com.ciberfarma.LP2_T2_TENORIOM_FRANKLIN.repository.ProveedorRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProveedorService {
	
	private final ProveedorRepository proveedorRepository;
	
	public List<ProveedorTF> getAll() {
		
		return proveedorRepository.findAll();
		
	}

}
