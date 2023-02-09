package com.pesnot.estado.msa.liquidacion.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

import static lombok.AccessLevel.PRIVATE;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = PRIVATE)
@Entity
@Table(name = "CatalogoActoNotarial")
public class ActoNotarial {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idCatalogoActoNotarial")
	private Long idCatalogoActoNotarial;
	

	@Column(name = "idTipoLibro")
	private Long idTipoLibro;

	@Column (name = "idBaseCobroActo")
	private Long idBaseCobroActo;

	@Column(name = "idTasaImpuesto")
	private Long idTasaImpuesto;
	
	@Column(name = "nombreCatalogoActoNotarial")
	private String nombreCatalogoActoNotarial;

	@Column(name = "articuloCatalogoActoNotarial")
	private String articuloCatalogoActoNotarial;
	
	@Column(name="tarifaCatalogoActoNotarial")
	private Double tarifaCatalogoActoNotarial;
	
	@Column(name = "gravaIVACatalogoActoNotarial")
	private Boolean gravaIvaCatalogoActoNotarial;
	
	@Column(name = "valorExoneracionCatalogoActoNotarial") 	
	private BigDecimal valorExoneracionCatalogoActoNotarial;
	
	@Column(name = "valorExtraCatalogoActoNotarial") 	
	private BigDecimal valorExtraCatalogoActoNotarial;

	@Column(name = "habilitableCiudadanoCatalogoActoNotarial")
	private Boolean habilitanteCiudadanoCatalogoActoNotarial;
	
	@Column(name = "tramiteUnilateralCatalogoActoNotarial")
	private Boolean tramiteUnilateralCatalogoActoNotarial;
	
	@Column(name = "tramiteBilateralCatalogoActoNotarial")
	private Boolean tramiteBilateralCatalogoActoNotarial;
	
	@Column(name="usaCalculoTablaCatalogoActoNotarial")
	private Boolean usaCalculoTablaCatalogoActoNotarial;
	
	@Column(name = "estadoCatalogoActoNotarial")
	private Boolean estadoCatalogoActoNotarial;
	
	@Column(name="fechaCreacionCatalogoActoNotarial")
	private Date fechaCreacionCatalogoActoNotarial;
	
	@Column(name="fechaModificacionCatalogoActoNotarial")
	private Date fechaModificacionCatalogoActoNotarial;
	
	@Column(name = "usuarioCreacionCatalogoActoNotarial")
	private Long usuarioCreacionCatalogoActoNotarial;
	
	@Column(name = "usuarioModificacionCatalogoActoNotarial")
	private Long usuarioModificacionCatalogoActoNotarial;
	

	
	
	
	
}
