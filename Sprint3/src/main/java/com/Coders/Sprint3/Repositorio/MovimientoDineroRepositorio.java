package com.Coders.Sprint3.Repositorio;

import com.Coders.Sprint3.Entidades.MovimientoDinero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovimientoDineroRepositorio extends JpaRepository<MovimientoDinero, Integer> {

}
