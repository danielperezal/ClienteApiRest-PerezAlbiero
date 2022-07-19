package com.segundaetapa.restapicliente.service.comprobante;

import com.segundaetapa.restapicliente.repository.ComprobanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComprobanteServiceImpl implements ComprobanteService {
    @Autowired
    ComprobanteRepository comprobanteRepository;
}
