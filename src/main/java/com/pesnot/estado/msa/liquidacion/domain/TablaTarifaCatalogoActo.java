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
@Entity(name = "TablaTarifaCatalogoActo")
public class TablaTarifaCatalogoActo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idTablaTarifaCatalogoActo")
	private Long idTablaTarifaCatalogoActo;


	@Column(name = "idTablaTarifa")
	private Long idTablaTarifa;

	@ManyToOne(targetEntity = ActoNotarial.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "idCatalogoActoNotarial", nullable = false)
	@JsonProperty(access = Access.READ_WRITE)
	private ActoNotarial idCatalogoActoNotarial;

	@Column(name = "fechaCreacionTablaTarifaCatalogoActo")
	private Date fechaCreacionTablaTarifaCatalogoActo;

	@Column(name = "fechaModificacionTablaTarifaCatalogoActo")
	private Date fechaModificacionTablaTarifaCatalogoActo;

	@Column(name = "usuarioCreacionTablaTarifaCatalogoActo")
	private Long usuarioCreacionTablaTarifaCatalogoActo;
	
	@Column(name = "usuarioModificacionTablaTarifaCatalogoActo")
	private Long usuarioModificacionTablaTarifaCatalogoActo;

	@Column(name = "estadoActivo")
	private Boolean estadoActivo;
	
}
