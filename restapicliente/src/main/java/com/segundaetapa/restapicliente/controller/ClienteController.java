package com.segundaetapa.restapicliente.controller;

import com.segundaetapa.restapicliente.dto.ClienteDto;
import com.segundaetapa.restapicliente.model.Cliente;
import com.segundaetapa.restapicliente.service.cliente.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("clientes")
public class ClienteController {
    @Autowired
    ClienteService clienteService;

    // -- GET MAPPING --

    @GetMapping("")
    public List<Cliente> mostrarTablaOriginal(){
        return clienteService.mostrarTodos();
    }

    @GetMapping("/{id}")
    public ClienteDto mostrarID(@PathVariable int id){
        return clienteService.mostrarClienteID(id) ;
    }

    @GetMapping("/all")
    public List<ClienteDto>mostrarTablaEdad(){

        return clienteService.mostrarListaEdad();
    }

    //-- POST MAPPING --

    @PostMapping("/crear")
    public Cliente crearCliente(@RequestBody Cliente cliente){
        return clienteService.crearCliente(cliente);
    }

    @PostMapping("/actualizar")
    public Cliente actualizarCliente(@RequestBody Cliente cliente){
        return clienteService.actualizarCliente(cliente);
    }

}
