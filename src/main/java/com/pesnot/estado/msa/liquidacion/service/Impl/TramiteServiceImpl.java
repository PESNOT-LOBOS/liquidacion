package com.pesnot.estado.msa.liquidacion.service.Impl;
import com.pesnot.estado.msa.liquidacion.domain.Tramite;
import com.pesnot.estado.msa.liquidacion.repository.TramiteRepository;
import com.pesnot.estado.msa.liquidacion.service.TramiteService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TramiteServiceImpl implements TramiteService{
    @Autowired
    private final TramiteRepository tramiteRepository;

    public TramiteServiceImpl(TramiteRepository tramiteRepository) {
        this.tramiteRepository = tramiteRepository;
    }

    @Override
    public List<Tramite> listarTodo() {
        return null;
    }
}
