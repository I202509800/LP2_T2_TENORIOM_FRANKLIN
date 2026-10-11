package com.ciberfarma.LP2_T2_TENORIOM_FRANKLIN.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="tbl_rubro")
@Getter
@Setter
public class RubroTF {
	
	@Id
	@Column(name="id_rubro")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idRubro;
	
	@Column(name="denominacion")
	private String denominacion;
	

}
