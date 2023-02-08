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

/*Data genera los getters and setters
 no args constructor y all args constructor genera los diferentes constructores
 FieldDefaults genera los modificadores de acceso
 Entity para el matcheo de la tabla de la base
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = PRIVATE)
@Entity
@Table(name = "Tramite")
public class Tramite {
    // Generate Value es el que genera automáticamente el id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTramite")
    Long id;

    @Column(name = "idEstadoTramite")
    Long idEstadoTramite;

    @Column(name = "idNotaria")
    Long idNotaria;

    @Column(name = "modalidadTramite")
    String modalidadTramite;

    @Column(name = "claveAccesoTramite")
    String claveAccesoTramite;

    @Column(name = "fechaTramite")
    Date fechaTramite;

    @Column(name = "numeroTemporalTramite")
    int numeroTemporalTramite;

    @Column(name = "numeroLibroTramite")
    String numeroLibroTramite;

    @Column(name = "fechaCreacionTramite")
    Date fechaCreacionTramite;

    @Column(name = "folioDesdeTramite")
    Long folioDesdeTramite;

    @Column(name = "folioHastaTramite")
    Long folioHastaTramite;

    @Column(name = "observacionTramite")
    String observacionTramite;

    @Column(name = "tipoLibroHistorico")
    String tipolibroHistorico;

    @Column(name = "usuarioMatrizadorTramite")
    String usuarioMatrizadorTramite;

    @Column(name = "valorSubtotalTramite")
    Double valorSubtotalTramite;

    @Column(name = "valorTotalTramite")
    Double valorTotalTramite;

    @Column(name = "valorParticipacionNotarioTramite")
    Double valorParticipacionNotarioTramite;

    @Column(name = "valorParticipacionEstadoTramite")
    Double valorParticipacionEstadoTramite;

    @Column(name = "estadoUAFTramite")
    Boolean estadoUAFTramite;

    @Column(name = "numeroFojasTramite")
    int numeroFojasTramite;

    @Column(name = "numeroHorasTramite")
    Double numeroHorasTramite;

    @Column(name = "fechaModificacionTramite")
    Date fechaModificacionTramite;

    @Column(name = "usuarioCreacionTramite")
    Long usuarioCreacionTramite;

    @Column(name = "usuarioModificacionTramite")
    Long usuarioModificacionTramite;

    @Column(name = "estadoActivoTramite")
    Boolean estadoActivoTramite;

    @Column(name = "idTramiteBpm")
    Long idTramiteBpm;

}
