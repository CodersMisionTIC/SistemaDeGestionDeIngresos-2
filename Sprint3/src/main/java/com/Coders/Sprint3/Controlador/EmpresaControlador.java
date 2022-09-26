package com.Coders.Sprint3.Controlador;

import com.Coders.Sprint3.Entidades.Empresa;
import com.Coders.Sprint3.Servicio.EmpresaServicio;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmpresaControlador {

    @Autowired
    EmpresaServicio empresaServicio;
//muestra todas las empresas
    @GetMapping("/enterprises")
    private List<Empresa> verEmpresa() {
        return empresaServicio.verEmpresa();
    }
//crea empresas
    @PostMapping("/enterprises")
    private void crearEmpresa(@RequestBody Empresa empresa) {
        empresaServicio.crearEmpresa(empresa);
    }
//borra la empresa por su id
    @DeleteMapping("/enterprises/{id}")
    private void eliminarEmpresa(@PathVariable("id") Integer id) {
        empresaServicio.eliminarEmpresa(id);
    }
//muestra a la empresa por su id
    @GetMapping("/enterprises/{id}")
    public Empresa consultarEmpresa(@PathVariable("id") Integer id){
        Optional<Empresa> consultarEmpresa = empresaServicio.consultarEmpresa(id);
        return consultarEmpresa.isEmpty()? new Empresa() : consultarEmpresa.get();
    }
//actualiza los datos de la empresa por su id
    @PatchMapping("/enterprises/{id}")
    public Empresa actualizarEmpresa(@PathVariable("id") Integer id, @RequestBody Empresa editarEmpresa){
        return empresaServicio.actualizarEmpresa(id, editarEmpresa);
    }

}
