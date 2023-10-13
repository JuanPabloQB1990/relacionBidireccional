package com.OneToMany.expocicion.services;

import com.OneToMany.expocicion.exceptions.ObjectNotFoundExceptions;
import com.OneToMany.expocicion.exceptions.RepeatFoundException;
import com.OneToMany.expocicion.models.Factura;
import com.OneToMany.expocicion.models.Linea;
import com.OneToMany.expocicion.repositories.RepositoryFactura;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FacturaService {

    @Autowired
    private RepositoryFactura repositoryFactura;


    public String crear(Factura factura) {

        Optional<Factura> facturaEncontrada = this.repositoryFactura.findById(factura.getFacturaId());

        if (facturaEncontrada.isPresent()){
            throw new RepeatFoundException("esta factura ya existe");
        }

        this.repositoryFactura.save(factura);
        return "factura creada satisfactoriamente";
    }


    public Optional<Factura> obtener(Integer id)  {
        Optional<Factura> factura = this.repositoryFactura.findById(id);

        if (!factura.isPresent()){
            throw new ObjectNotFoundExceptions("factura no encontrada");
        }

        return factura;

    }
}
