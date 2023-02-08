package com.pesnot.estado.msa.liquidacion.service;

import com.pesnot.estado.msa.liquidacion.domain.Tramite;


import java.util.*;

public interface TramiteService {

    public List<Tramite> listarTramites();
    public List<Tramite> listarTramitesActivos();
    public Optional<Tramite> buscarId(String id);
    public List<Tramite> listarTramitesNotaria(String id);
    public List<Tramite> listarTramitesNotariaFechaExacta(String id, Date mes);
    public List<Tramite> listarTramitesNotariaFechaMes(String id, int mes);
    public List<Tramite> listarTramitesNotariaFechaMesAño(String id, int mes,int año);
    public String calcularTotalParticipacionEstadoTramitesNotariaFechaMesAño(String id, int mes, int año);
    public Double calcularValorSinIvaNotariaFechaMes(String id, int mes, int año);
    public Double calcularParticipacionEstadoTramitesNotariaFechaMesAño(String id, int mes, int año);
    public Double calcularOtrosValoresNotariaFechaMes(String id, int mes, int año);
    public Double calcularValorDepositarNotariaFechaMesAño( Double participacionEstado, Double multas, Double intereses, Double notasCredito, Double pagoExceso) ;

    public Tramite guardarTramite(Tramite tramiteEntrante);

}
