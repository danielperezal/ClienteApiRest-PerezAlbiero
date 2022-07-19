package com.segundaetapa.restapicliente.repository;

import com.segundaetapa.restapicliente.model.Comprobante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComprobanteRepository extends JpaRepository<Comprobante,Integer> {
}
