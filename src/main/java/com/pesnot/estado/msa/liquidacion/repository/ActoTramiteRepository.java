package com.pesnot.estado.msa.liquidacion.repository;

import java.util.*;

import com.pesnot.estado.msa.liquidacion.domain.ActoTramite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ActoTramiteRepository extends JpaRepository<ActoTramite,Long> {
    @Query(nativeQuery = true,value="SELECT * FROM ActoTramite WHERE estadoActivo='true'")
    public List<ActoTramite> listarActosTramiteActivos();
    @Query(nativeQuery = true,value="SELECT * FROM ActoTramite a WHERE a.idTramite= :idTramite")
    public List<ActoTramite> listarActosIdTramites(@Param("idTramite") String idTramite);
    @Query(nativeQuery = true,value="SELECT * FROM ActoTramite a WHERE a.idCatalogoActoNotarial= :idActo")
    public List<ActoTramite> listarIdActoTramites(@Param("idActo") String idActo);
}
