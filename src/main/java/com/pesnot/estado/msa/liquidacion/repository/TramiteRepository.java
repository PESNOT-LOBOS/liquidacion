package com.pesnot.estado.msa.liquidacion.repository;
import java.util.*;

import com.pesnot.estado.msa.liquidacion.domain.Tramite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TramiteRepository extends JpaRepository<Tramite,Long> {
    @Query(nativeQuery = true,value="SELECT * FROM Tramite WHERE estadoActivoTramite='true'")
    public List<Tramite> listarTramitesActivos();

    @Query(nativeQuery = true,value="SELECT * FROM Tramite WHERE idNotaria=:id")
    public List<Tramite> listarTramitesNotaria(@Param("id") String id);
}
