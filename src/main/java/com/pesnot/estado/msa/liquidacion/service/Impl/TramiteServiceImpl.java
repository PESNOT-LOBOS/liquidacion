package com.pesnot.estado.msa.liquidacion.service.Impl;
import com.pesnot.estado.msa.liquidacion.domain.Tramite;
import com.pesnot.estado.msa.liquidacion.repository.TramiteRepository;
import com.pesnot.estado.msa.liquidacion.service.TramiteService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

public class TramiteServiceImpl implements TramiteService{
    @Autowired
    private final TramiteRepository tramiteRepository;

    public TramiteServiceImpl(TramiteRepository tramiteRepository) {
        this.tramiteRepository = tramiteRepository;
    }

    @Override
    public List<Tramite> listarTramites() {
        return tramiteRepository.listarTramites();
    }

    @Override
    public List<Tramite> listarTramitesActivos() {
        return tramiteRepository.listarTramitesActivos();
    }

    @Override
    public List<Tramite> listarTramitesNotaria(String id) {
        return tramiteRepository.listarTramitesNotaria(id);
    }

    @Override
    public List<Tramite> listarTramitesNotariaFechas(String id, Date fecha) {
        return tramiteRepository.listarTramitesNotariaFechas(id, fecha);
    }
}
