package com.ciberfarma.LP2_T2_TENORIOM_FRANKLIN.model;


import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="tbl_proveedor")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProveedorTF {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	@Column(name = "id_proveedor")
	private Integer idProveedor;
	
	@Column(name="ruc")
	private String ruc;
	
	@Column(name="razon_social")
	private String razonSocial;
	
	@Column(name = "fecha_registro")
	private LocalDateTime fechaRegistro;
	
	@Column(name="direccion")
	private String direccion;
	
	@Column(name="pagina_web")
	private String paginaWeb;
	
	@ManyToOne
	@JoinColumn(name="id_rubro")
	private RubroTF rubro;
	
	public String getDescripcion() {
		return ruc + " " + razonSocial;
		
	}
	

}
