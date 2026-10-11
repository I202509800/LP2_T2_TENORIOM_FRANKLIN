package com.ciberfarma.LP2_T2_TENORIOM_FRANKLIN.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tbl_orden_compra")
@Getter
@Setter
public class OrdenCompraTF {
	
	@Id
	@Column(name="nro_orden")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer nroOrden;
	
	@ManyToOne
	@JoinColumn(name="id_proveedor")
	private ProveedorTF proveedor;
	
	@Column(name ="monto")
	private BigDecimal monto;
	
	@Column(name="direccion_entrega")
	private String direccionEntrega;
	
	@Column(name="fecha_entrega")
	private LocalDate fechaEntrega;
	
	@Column(name="estado")
	private String estado;
	
	public String getEstadoDescripcion() {
		return estado == null ? "Sin estado" :
	           estado.equals("P") ? "Pendiente" :
	           estado.equals("C") ? "Completado" :
	           estado.equals("A") ? "Anulado" :
	           "Estado desconocido";
	}

}
