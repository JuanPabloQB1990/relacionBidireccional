package com.OneToMany.expocicion.repositories;

import com.OneToMany.expocicion.dto.LineaDto;
import com.OneToMany.expocicion.models.Linea;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface LineaRepository extends CrudRepository<Linea, Integer> {

    @Transactional
    @Modifying
    @Query(value = "insert into linea(id, producto, precio, cantidad, factura_id)values(:id, :producto, :precio, :cantidad, :factura_id)", nativeQuery = true)
    void guardar(@Param("id")Integer id,@Param("producto")String producto, @Param("precio")Double precio, @Param("cantidad")Integer cantidad, @Param("factura_id")Integer factura_id);
}
