package com.segundaetapa.restapicliente.service.cliente;

import com.segundaetapa.restapicliente.dto.ClienteDto;
import com.segundaetapa.restapicliente.model.Cliente;
import com.segundaetapa.restapicliente.repository.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
@Service
public class ClienteServiceImpl implements ClienteService {

 @Autowired
         ClientesRepository clientesRepository;

    Cliente cliente;
    int edad;
    List<Cliente> copialista;


    //-- GET --

    @Override
    public List<Cliente> mostrarTodos() {
        return clientesRepository.findAll();
    }

    @Override
    public ClienteDto mostrarClienteID(int id) {
        cliente= clientesRepository.findById(id).orElse(null);
        if(cliente!=null) {
            edad = cacularedad(cliente);
            ClienteDto clienteamostrar = crearClienteDto(cliente);
            return clienteamostrar;
        }
        return null;
    }

    @Override
    public ClienteDto mostrarClienteDNI(int dni) {
        return null;
    }

    @Override
    public List<ClienteDto> mostrarListaEdad() {
        copialista=clientesRepository.findAll();
        List<ClienteDto> listaamostar=new ArrayList<>();
        int finalLista = copialista.size();
        for(int i=0;i<finalLista;i++){
            cliente=copialista.get(i);
            edad=cacularedad(cliente);
            ClienteDto clienteamostrar = crearClienteDto(cliente);
            listaamostar.add(clienteamostrar);
        }
        return listaamostar;
    }

    //-- METODOS POST --


    @Override
    public Cliente crearCliente(Cliente cliente) {
        int idNuevo= calcularIdNuevo();
        cliente.setIdcliente(idNuevo);
        return clientesRepository.save(cliente);
    }

    @Override
    public Cliente actualizarCliente(Cliente cliente) {
        int idclienteaactualizar = cliente.getIdcliente();
        int cantidadDeClientesEnMiTabla= clientesRepository.findAll().size();
        if(idclienteaactualizar>0 && idclienteaactualizar<=cantidadDeClientesEnMiTabla){
            return clientesRepository.save(cliente);
        }
        return null;
    }



    //   --  METODOS PARA CALCULAR --


    private int calcularIdNuevo() {
        copialista = clientesRepository.findAll();
        int tamanioLista= copialista.size();
        int idnuevo= tamanioLista+1;
        return idnuevo;
    }

    private int cacularedad(Cliente cliente) {
        Date fecha= cliente.getFechanacimiento();
        String fechaString = fecha.toString();
        int anio = Integer.parseInt(fechaString.substring(0,4));
        int mes = Integer.parseInt(fechaString.substring(5,7));
        int dia = Integer.parseInt(fechaString.substring(8,10));
        int edad = Period.between(LocalDate.of(anio,mes,dia),LocalDate.now()).getYears();
        return edad;
    }

    private ClienteDto crearClienteDto(Cliente cliente){
        ClienteDto clientecreado = new ClienteDto(cliente.getIdcliente(), cliente.getDni(), cliente.getNombre(), cliente.getApellido(), edad);
        return clientecreado;
    }

}
