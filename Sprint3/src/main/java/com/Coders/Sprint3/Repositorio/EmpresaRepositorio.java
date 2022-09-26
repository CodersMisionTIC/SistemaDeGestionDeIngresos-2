package com.Coders.Sprint3.Repositorio;

import com.Coders.Sprint3.Entidades.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaRepositorio extends JpaRepository<Empresa, Integer> {

}
