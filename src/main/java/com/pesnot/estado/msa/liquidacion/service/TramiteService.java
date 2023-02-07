package com.pesnot.estado.msa.liquidacion.service;

import com.pesnot.estado.msa.liquidacion.domain.Tramite;


import java.util.*;

public interface TramiteService {

    public List<Tramite> listarTramites();
    public List<Tramite> listarTramitesActivos();
    public List<Tramite> listarTramitesNotaria(String id);
    public List<Tramite> listarTramitesNotariaFecha(String id, Date mes);
    public List<Tramite> listarTramitesNotariaFechaMes(String id, int mes);
    public Double calcularLiquidacionSinIVAParticipacionEstadoNotariaFechaMes(String id, int mes);
    public Optional<Tramite> buscarId(String id);
    public Tramite guardarTramite(Tramite tramiteEntrante);

}
