package com.pesnot.estado.msa.liquidacion.service;

import com.pesnot.estado.msa.liquidacion.domain.ActoTramite;
import com.pesnot.estado.msa.liquidacion.domain.Tramite;

import java.util.List;
import java.util.Optional;

public interface ActoTramiteService {

    public List<ActoTramite> listarActoTramites();
    public List<ActoTramite> listarActoTramitesActivos();
    public List<ActoTramite> listarActosIdTramite(String idTramite);
    public List<ActoTramite> listarIdActosTramite(String idActos);
    public List<ActoTramite> listarActoTramitePorId(String idActos);
    public String calcularParticipacionEstadoDeValor();
    public Optional<ActoTramite> buscarId(String id);
    public ActoTramite guardarActoTramite(ActoTramite tramiteEntrante);

    public Long getSBUParametro();
}
