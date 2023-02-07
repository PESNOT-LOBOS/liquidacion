package com.pesnot.estado.msa.liquidacion.domain;
import static lombok.AccessLevel.PRIVATE;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = PRIVATE)
@Entity
@Table(name = "ActoTramite")
public class ActoTramite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idActoTramite")
    Long idActoTramite;

    @Column(name = "idCatalogoActoNotarial")
    Long idCatalogoActoNotarial;

    @Column(name = "idTramite")
    Long idTramite;

    @Column(name = "fechaInicioActoTramite")
    Date fechaInicioActoTramite;

    @Column(name = "fechaFinActoTramite")
    Date fechaFinActoTramite;

    @Column(name = "numeroIntervinientesActoTramite")
    int numeroIntervinientesActoTramite;

    @Column(name = "observacionActoTramite")
    String observacionActoTramite;

    @Column(name="alicuotaComercialActoTramite")
    Double alicuotaComercialActoTramite;

    @Column(name="alicuotaViviendaActoTramite")
    Double alicuotaViviendaActoTramite;

    @Column(name="aplicaFueraDespachoActoTramite")
    Boolean aplicaFueraDespachoActoTramite;

    @Column(name="avaluoMunicipalActoTramite")
    Boolean avaluoMunicipalActoTramite;

    @Column(name="cuantiaActoTramite")
    Double cuantiaActoTramite;

    @Column(name="numeroFojasActoTramite")
    int numeroFojasActoTramite;

    @Column(name="numeroHorasActoTramite")
    int numeroHorasActoTramite;

    @Column(name="pagadoActoTramite")
    Boolean pagadoActoTramite;

    @Column(name="valorActoTramiteActoTramite")
    Double valorActoTramiteActoTramite;

    @Column(name="valorExoneracionActoTramite")
    Double valorExoneracionActoTramite;

    @Column(name="valorParticipacionEstadoActoTramite")
    Double valorParticipacionEstadoActoTramite;

    @Column(name="valorParticipacionNotarioActoTramite")
    Double valorParticipacionNotarioActoTramite;

    @Column(name="estadoActivo")
    Boolean estadoActivo;
}
