package com.segundaetapa.restapicliente.controller;

import com.segundaetapa.restapicliente.service.comprobante.ComprobanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("comprobantes")
public class ComprobanteController {
    @Autowired
    ComprobanteService comprobanteService;
}
