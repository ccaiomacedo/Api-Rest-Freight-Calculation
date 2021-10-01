package com.caiodev.FreightCalculation.repository;

import com.caiodev.FreightCalculation.domain.Freight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FreightRepository extends JpaRepository<Freight, Integer> {

    @Query("SELECT obj FROM Freight obj WHERE obj.cepOrigem = :cepOrigem AND " + "obj.cepDestino = :cepDestino AND "
            + "obj.nomeDestinatario = :nomeDestinatario ")
    Optional<Freight> findByFreight(String cepOrigem, String cepDestino, String nomeDestinatario);
}
