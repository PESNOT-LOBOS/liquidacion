package com.pesnot.estado.msa.liquidacion.service.Impl;

import com.pesnot.estado.msa.liquidacion.domain.Tramite;
import com.pesnot.estado.msa.liquidacion.repository.TramiteRepository;
import com.pesnot.estado.msa.liquidacion.service.TramiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TramiteServiceImpl implements TramiteService {
    @Autowired
    private final TramiteRepository tramiteRepository;

    public TramiteServiceImpl(TramiteRepository tramiteRepository) {
        this.tramiteRepository = tramiteRepository;
    }

    @Override
    public List<Tramite> listarTramites() {
        return tramiteRepository.findAll();
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
    public Optional<Tramite> buscarId(String id) {
        return tramiteRepository.findById(Long.parseLong(id));  //
    }

    @Override
    public Tramite guardarTramite(Tramite tramiteEntrante) {
        return tramiteRepository.save(tramiteEntrante);
    }

}
