package com.pesnot.estado.msa.liquidacion.service.Impl;

import com.pesnot.estado.msa.liquidacion.domain.ActoTramite;
import com.pesnot.estado.msa.liquidacion.repository.ActoTramiteRepository;
import com.pesnot.estado.msa.liquidacion.service.ActoTramiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class ActoTramiteServiceImpl implements ActoTramiteService {
    @Autowired
    private final ActoTramiteRepository actoTramiteRepository;

    public ActoTramiteServiceImpl(ActoTramiteRepository actoTramiteRepository) {
        this.actoTramiteRepository = actoTramiteRepository;
    }

    @Override
    public List<ActoTramite> listarActoTramites() {
        return actoTramiteRepository.findAll();
    }

    @Override
    public List<ActoTramite> listarActoTramitesActivos() {
        return actoTramiteRepository.listarActosTramiteActivos();
    }

    @Override
    public List<ActoTramite> listarActosIdTramite(String idTramite) {
        return actoTramiteRepository.listarActosIdTramites(idTramite);
    }

    @Override
    public List<ActoTramite> listarIdActosTramite(String idActos) {
        return actoTramiteRepository.listarActosActoTramites(idActos);
    }

    @Override
    public List<ActoTramite> listarActoTramitePorId(String idActos) {
        return null;
    }

    @Override
    public Optional<ActoTramite> buscarId(String id) {
        return actoTramiteRepository.findById(Long.parseLong(id));
    }

    @Override
    public ActoTramite guardarActoTramite(ActoTramite tramiteEntrante) {
        return actoTramiteRepository.save(tramiteEntrante);
    }
}
