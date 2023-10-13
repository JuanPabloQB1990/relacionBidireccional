package com.OneToMany.expocicion.controllers;

import com.OneToMany.expocicion.models.Factura;
import com.OneToMany.expocicion.models.Linea;
import com.OneToMany.expocicion.services.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/facturas")
public class FacturaController {

    @Autowired
    private FacturaService facturaService;

    @PostMapping
    public ResponseEntity<String> crearFactura(@RequestBody Factura factura){
        return new ResponseEntity<>(this.facturaService.crear(factura), HttpStatus.CREATED) ;
    }

    @GetMapping(path = "{id}")
    public Optional<Factura> obtenerFacturaPorId(@PathVariable("id") Integer id)  {
        return this.facturaService.obtener(id);
    }

}
