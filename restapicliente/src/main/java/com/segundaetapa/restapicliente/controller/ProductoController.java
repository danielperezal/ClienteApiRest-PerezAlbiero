package com.segundaetapa.restapicliente.controller;

import com.segundaetapa.restapicliente.model.Producto;
import com.segundaetapa.restapicliente.service.producto.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("productos")
public class ProductoController {

    @Autowired
    ProductoService productoService;

    // -- GET MAPPING --

    @GetMapping("")
    public List<Producto> mostrarTablaOriginal(){
        return productoService.mostrarTodos() ;
    }

    @GetMapping("/{id}")
    public Producto mostrarProductoID(@PathVariable int id){
        return productoService.mostrarProductoID(id) ;
    }


    //  -- POST MAPPING --

    @PostMapping("/crear")
    public Producto crearProducto(@RequestBody Producto producto){
        return productoService.crearProducto(producto);
    }

    @PostMapping("/actualizar")
    public Producto actualizarProducto(@RequestBody Producto producto){
        return productoService.actualizarProducto(producto);
    }
}
