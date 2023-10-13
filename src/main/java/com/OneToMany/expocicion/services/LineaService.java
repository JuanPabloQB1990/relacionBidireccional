package com.OneToMany.expocicion.services;

import com.OneToMany.expocicion.dto.LineaDto;
import com.OneToMany.expocicion.exceptions.ObjectNotFoundExceptions;
import com.OneToMany.expocicion.exceptions.RepeatFoundException;
import com.OneToMany.expocicion.models.Linea;
import com.OneToMany.expocicion.repositories.LineaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class LineaService {

    @Autowired
    private LineaRepository lineaRepository;
    public String crear(Linea linea) {

        Optional<Linea> lineaEncontrada = this.lineaRepository.findById(linea.getId());

        if (lineaEncontrada.isPresent()){
            throw new RepeatFoundException("esta linea ya existe");
        }

        this.lineaRepository.guardar(linea.getId(),
                                     linea.getProducto(),
                                     linea.getPrecio(),
                                     linea.getCantidad(),
                                     linea.getFactura().getFacturaId());
        return "linea creada satisfactoriamente";
    }

    public  Map<String, Object> obtener(Integer id) throws UserPrincipalNotFoundException {
        Linea lineaEncontrada = this.lineaRepository.findById(id).get();

        Map<String, Object> datos = new HashMap<>();
        datos.put("producto", lineaEncontrada.getProducto());
        datos.put("precio", lineaEncontrada.getPrecio());
        datos.put("cantidad", lineaEncontrada.getCantidad());
        datos.put("id_factura", lineaEncontrada.getFactura().getFacturaId());
        datos.put("fecha", lineaEncontrada.getFactura().getFecha());
        datos.put("nombre_cliente", lineaEncontrada.getFactura().getNombre_cliente());
        datos.put("ciudad", lineaEncontrada.getFactura().getCiudad());
        datos.put("telefono_cliente", lineaEncontrada.getFactura().getTelefono_cliente());
        datos.put("correo_cliente", lineaEncontrada.getFactura().getCorreo_cliente());

        if (lineaEncontrada == null){
            throw new ObjectNotFoundExceptions("linea no encontrada");
        }

        return datos;
    }
}
