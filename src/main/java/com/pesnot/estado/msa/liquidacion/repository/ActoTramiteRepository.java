package com.pesnot.estado.msa.liquidacion.repository;

import com.pesnot.estado.msa.liquidacion.domain.ActoTramite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ActoTramiteRepository extends JpaRepository<ActoTramite,Long> {
    @Query(nativeQuery = true,value="SELECT * FROM ActoTramite WHERE estadoActivo='true'")
    public List<ActoTramite> listarActosTramiteActivos();
    @Query(nativeQuery = true,value="SELECT * FROM ActoTramite WHERE idTramite= :idTaramite")
    public List<ActoTramite> listarActosIdTramites(@Param("idTramite") String idTramite);
    @Query(nativeQuery = true,value="SELECT * FROM ActoTramite WHERE idCatalogoActoNotarial= :idActo")
    public List<ActoTramite> listarActosActoTramites(@Param("idActo") String idActo);
}
