package com.OneToMany.expocicion.models;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "factura")
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer facturaId;

    @Column(name = "fecha")
    private LocalDate fecha;

    @Column(name = "nombre_cliente")
    private String nombre_cliente;

    @Column(name = "ciudad")
    private String ciudad;

    @Column(name = "telefono_cliente")
    private String telefono_cliente;

    @Column(name = "correo_cliente")
    private String correo_cliente;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "factura")
    private List<Linea> lineas = new ArrayList<>();


}
