package com.pesnot.estado.msa.liquidacion.service;

import com.pesnot.estado.msa.liquidacion.domain.Tramite;
import com.pesnot.estado.msa.liquidacion.repository.TramiteRepository;

import java.util.*;

public interface TramiteService {



    public List<Tramite> listarTramites();
    public List<Tramite> listarTramitesActivos();
    public List<Tramite> listarTramitesNotaria(String id);
    public List<Tramite> listarTramitesNotariaFechas(String id, Date fecha);

}
