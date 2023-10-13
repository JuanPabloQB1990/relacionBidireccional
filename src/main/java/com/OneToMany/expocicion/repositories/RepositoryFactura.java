package com.OneToMany.expocicion.repositories;

import com.OneToMany.expocicion.models.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface RepositoryFactura extends JpaRepository<Factura, Integer> {

}
