package com.OneToMany.expocicion.dto;

import com.OneToMany.expocicion.models.Factura;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LineaDto {
    private Integer id;
    private String producto;
    private double precio;
    private int cantidad;
    private Factura factura;
}
