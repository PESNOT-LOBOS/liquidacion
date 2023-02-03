package com.pesnot.estado.msa.liquidacion.controller;

import com.pesnot.estado.msa.liquidacion.domain.Tramite;
import com.pesnot.estado.msa.liquidacion.service.TramiteService;
import groovy.util.logging.Slf4j;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/tramites/")
public class TramiteController {

    private final TramiteService tramiteService;

    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Tramite> listarTramites() {
        return this.tramiteService.listarTramites();
    }
    @GetMapping(value = "activos", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Tramite> listarTramitesActivos() {
        return this.tramiteService.listarTramitesActivos();
    }
    @GetMapping(value = "activos/{notaria}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Tramite> listarTramitesNotarias(@PathVariable String notaria) {
        return this.tramiteService.listarTramitesNotaria(notaria);
    }
    @GetMapping(value = "activos/{notaria}/{fecha}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Tramite> listarTramitesNotariasFechas(@PathVariable String notaria,@PathVariable Date fecha) {
        return this.tramiteService.listarTramitesNotariaFechas(notaria,fecha);
    }

}
