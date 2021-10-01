package com.caiodev.FreightCalculation.repository;

import com.caiodev.FreightCalculation.domain.Freight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FreightRepository extends JpaRepository<Freight, Integer> {

    List<Freight> findByNomeDestinatarioIgnoreCase(String name);

    @Query("SELECT obj FROM Freight obj WHERE obj.cepOrigem = :cepOrigem AND " + "obj.cepDestino = :cepDestino")
    List<Freight> findByCep(String cepOrigem, String cepDestino);

}
