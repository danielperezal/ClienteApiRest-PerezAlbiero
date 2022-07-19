package com.segundaetapa.restapicliente.service.producto;

import com.segundaetapa.restapicliente.model.Producto;

import java.util.List;

public interface ProductoService {

    List<Producto> mostrarTodos();
    Producto mostrarProductoID(int id);

    Producto crearProducto(Producto producto);

    Producto actualizarProducto(Producto producto);


}
