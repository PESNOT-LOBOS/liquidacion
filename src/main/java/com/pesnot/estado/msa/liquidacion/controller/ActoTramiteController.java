package com.pesnot.estado.msa.liquidacion.controller;

import com.pesnot.estado.msa.liquidacion.domain.ActoTramite;
import com.pesnot.estado.msa.liquidacion.service.ActoTramiteService;
import groovy.util.logging.Slf4j;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/actoTramites")
public class ActoTramiteController {

    private final ActoTramiteService actoTramiteService;

    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ActoTramite> listarActosTramites() {
        return this.actoTramiteService.listarActoTramites();
    }

    @GetMapping(value = "activos", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ActoTramite> listarActosTramitesActivos() {
        return this.actoTramiteService.listarActoTramitesActivos();
    }

    @GetMapping(value = "tramite/{idTramite}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ActoTramite> listarActosTramiteId(@PathVariable String idTramite) {
        return this.actoTramiteService.listarActosIdTramite(idTramite);
    }

    @GetMapping(value = "acto/{idActo}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ActoTramite> listarIdActosTramite(@PathVariable String idActo) {
        return this.actoTramiteService.listarIdActosTramite(idActo);
    }

    @GetMapping(value = "id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<ActoTramite> listarTramiteId(@PathVariable String idEntrante) {
        return this.actoTramiteService.buscarId(idEntrante);
    }

    @PostMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ActoTramite guardarTramites(@RequestParam(required = false) ActoTramite tramiteEntrante) {
        return this.actoTramiteService.guardarActoTramite(tramiteEntrante);
    }
}
