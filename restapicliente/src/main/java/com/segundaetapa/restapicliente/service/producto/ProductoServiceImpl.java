package com.segundaetapa.restapicliente.service.producto;

import com.segundaetapa.restapicliente.model.Producto;
import com.segundaetapa.restapicliente.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceImpl implements ProductoService {
    @Autowired
    ProductoRepository productoRepository;

    // -- METODOS GET --

    @Override
    public List<Producto> mostrarTodos() {
        return productoRepository.findAll();
    }

    @Override
    public Producto mostrarProductoID(int id) {
        return productoRepository.findById(id).orElse(null);
    }

    // -- METODOS POST --

    @Override
    public Producto crearProducto(Producto producto) {
        int idNuevo= calcularIdNuevo();
        producto.setIdproducto(idNuevo);
        return productoRepository.save(producto);
    }


    @Override
    public Producto actualizarProducto(Producto producto) {
        int idproductoaactualizar = producto.getIdproducto();
        int cantidadDeClientesEnMiTabla= productoRepository.findAll().size();
        if(idproductoaactualizar>0 && idproductoaactualizar<=cantidadDeClientesEnMiTabla){
            return productoRepository.save(producto);
        }
        return null;
    }

        // --  METODOS AUXILIARES  --

        private int calcularIdNuevo() {
        int tamanioLista= productoRepository.findAll().size();
        int idnuevo= tamanioLista+1;
        return idnuevo;
    }
}
