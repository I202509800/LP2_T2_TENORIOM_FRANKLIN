package com.ciberfarma.LP2_T2_TENORIOM_FRANKLIN.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ciberfarma.LP2_T2_TENORIOM_FRANKLIN.model.OrdenCompraTF;
import com.ciberfarma.LP2_T2_TENORIOM_FRANKLIN.service.OrdenCompraService;
import com.ciberfarma.LP2_T2_TENORIOM_FRANKLIN.service.ProveedorService;
import com.ciberfarma.LP2_T2_TENORIOM_FRANKLIN.util.Alert;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("producto")
@RequiredArgsConstructor
public class OrdenCompraController {
	
	private final OrdenCompraService ordenCompraService;
	private final ProveedorService proveedorService;
	
	@GetMapping("listadoTenorioFranklin")
	public String listado(Model model) {
		model.addAttribute("lstOrdenes", ordenCompraService.getAll());
		return "producto/listadoTenorioFranklin";
	}
	
	@GetMapping("nuevo")
	public String nuevo(Model model) {
		model.addAttribute("lstProveedores", proveedorService.getAll());
		model.addAttribute("ordenCompra", new OrdenCompraTF());
		return "producto/nuevoTenorioFranklin";
		
	}
	
	@GetMapping("edicion/{id}")             /*22*/
	public String edicion(@PathVariable Integer id, Model model) {       /*22*/      
		model.addAttribute("lstProveedores", proveedorService.getAll());    
		model.addAttribute("ordenCompra", ordenCompraService.getOne(id));  /*22*/  
		return "/producto/edicionTenorioFranklin";     
	}
	
	@PostMapping("registrar")         /*18*/
	public String registrar(@ModelAttribute OrdenCompraTF ordenCompraTF, RedirectAttributes flash) {   /*18*/
		
		var response = ordenCompraService.create(ordenCompraTF);    /*18*/
		
		flash.addFlashAttribute("alert", Alert.sweetToast(response.mensaje(), "success", 5000));   /*18*/
		
		return "redirect:/producto/listadoTenorioFranklin";            
	}
	
	@PostMapping("guardar")         
	public String guardar(@ModelAttribute OrdenCompraTF ordenCompraTF, RedirectAttributes flash) {   
		
		var response = ordenCompraService.update(ordenCompraTF);    
		
		flash.addFlashAttribute("alert", Alert.sweetToast(response.mensaje(), "success", 5000));   
		
		return "redirect:/producto/listadoTenorioFranklin";            
	}
	

}
