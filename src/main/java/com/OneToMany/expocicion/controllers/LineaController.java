package com.OneToMany.expocicion.controllers;

import com.OneToMany.expocicion.models.Factura;
import com.OneToMany.expocicion.models.Linea;
import com.OneToMany.expocicion.services.LineaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/lineas")
public class LineaController {

    @Autowired
    private LineaService lineaService;

    @PostMapping
    public ResponseEntity<String> crearLinea(@RequestBody Linea linea){
        return new ResponseEntity<>(this.lineaService.crear(linea), HttpStatus.CREATED) ;
    }

    @GetMapping(path = "{id}")
    public  Map<String, Object> obtenerLineaPorId(@PathVariable("id") Integer id) throws UserPrincipalNotFoundException {
        return this.lineaService.obtener(id);
    }
}
