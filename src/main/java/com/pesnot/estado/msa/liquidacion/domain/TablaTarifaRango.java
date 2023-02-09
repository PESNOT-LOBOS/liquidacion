package com.pesnot.estado.msa.liquidacion.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Date;

import static lombok.AccessLevel.PRIVATE;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = PRIVATE)
@Entity
@Table(name = "TablaTarifaRango")
public class TablaTarifaRango {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idTablaTarifaRango")
	private Long idTablaTarifaRango;

	@Column(name = "idRangoTarifa", nullable = false)
	private Long idRangoTarifa;
	

	@Column(name = "idTablaTarifa", nullable = false)
	private Long idTablaTarifa;
	
	@Column(name = "porcentajeTablaTarifaRango")
	private Double porcentajeTablaTarifaRango;

	@Column(name = "porcentajeParticipacionNotarioTablaTarifaRango")
	private Double porcentajeParticipacionNotarioTablaTarifaRango;

	@Column(name = "porcentajeParticipacionEstadoTablaTarifaRango")
	private Double porcentajeParticipacionEstadoTablaTarifaRango;

	@Column(name = "excedenteTablaTarifaRango")
	private Double excedenteTablaTarifaRango;


	@Column(name = "fechaCreacionTablaTarifaRango")
	private Date fechaCreacionTablaTarifa;

	@Column(name = "fechaModificacionTablaTarifaRango")
	private Date fechaModificacionTablaTarifaRango;

	@Column(name = "usuarioCreacionTablaTarifaRango")
	private Long usuarioCreacionTablaTarifa;
	
	@Column(name = "usuarioModificacionTablaTarifaRango")
	private Long usuarioModificacionTablaTarifa;

	@Column(name = "estadoTablaTarifaRango")
	private Boolean estadoTablaTarifaRango;
}
