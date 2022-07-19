package com.segundaetapa.restapicliente.service.cliente;

import com.segundaetapa.restapicliente.dto.ClienteDto;
import com.segundaetapa.restapicliente.model.Cliente;

import java.util.List;

public interface ClienteService {
    List<Cliente> mostrarTodos();

    ClienteDto mostrarClienteID(int id);

    ClienteDto mostrarClienteDNI(int dni);

    List<ClienteDto>mostrarListaEdad();

    Cliente crearCliente(Cliente cliente);

    Cliente actualizarCliente(Cliente cliente);



}