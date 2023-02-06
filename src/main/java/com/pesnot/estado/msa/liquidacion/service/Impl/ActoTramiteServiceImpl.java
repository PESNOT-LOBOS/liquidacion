package com.pesnot.estado.msa.liquidacion.service.Impl;

import com.pesnot.estado.msa.liquidacion.domain.ActoTramite;
import com.pesnot.estado.msa.liquidacion.repository.ActoTramiteRepository;
import com.pesnot.estado.msa.liquidacion.service.ActoTramiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActoTramiteServiceImpl implements ActoTramiteService {
    @Autowired
    private final ActoTramiteRepository actoTramiteRepository;

    public ActoTramiteServiceImpl(ActoTramiteRepository actoTramiteRepositoryE) {
        this.actoTramiteRepository = actoTramiteRepositoryE;
    }
    
    @Override
    public List<ActoTramite> listarActoTramites() {
        return null;
    }

    @Override
    public List<ActoTramite> listarActoTramitesActivos() {
        return null;
    }

    @Override
    public List<ActoTramite> listarActosIdTramite(String idTramite) {
        return null;
    }

    @Override
    public List<ActoTramite> listarIdActosTramite(String idActos) {
        return null;
    }

    @Override
    public Optional<ActoTramite> buscarId(String id) {
        return Optional.empty();
    }

    @Override
    public ActoTramite guardarActoTramite(ActoTramite tramiteEntrante) {
        return null;
    }
}
