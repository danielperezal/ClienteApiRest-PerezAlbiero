package com.segundaetapa.restapicliente.repository;

import com.segundaetapa.restapicliente.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ClientesRepository extends JpaRepository <Cliente,Integer> {

}
