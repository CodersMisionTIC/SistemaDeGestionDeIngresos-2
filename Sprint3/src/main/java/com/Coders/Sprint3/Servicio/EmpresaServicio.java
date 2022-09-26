package com.Coders.Sprint3.Servicio;

import com.Coders.Sprint3.Entidades.Empresa;
import com.Coders.Sprint3.Repositorio.EmpresaRepositorio;
import net.bytebuddy.dynamic.DynamicType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmpresaServicio {


    @Autowired
    EmpresaRepositorio empresaRepositorio;

//Crea una empresa
    public void crearEmpresa(Empresa empresa){
        empresaRepositorio.save(empresa);
    }

//muestra las empresas creadas
    public List<Empresa> verEmpresa(){
        List<Empresa> empresas = new ArrayList<Empresa>();
        empresas.addAll(empresaRepositorio.findAll());
        return empresas;
    }

//elimina la empresa por id
    public void eliminarEmpresa(Integer id) {
        empresaRepositorio.deleteById(id);
    }

//consulta la empresa por el id
    public Optional<Empresa> consultarEmpresa(Integer id) {
        return empresaRepositorio.findById(id);}

//actualiza la empresa por el id
    public Empresa actualizarEmpresa(Integer id, Empresa editarEmpresa) {
        Empresa pathEmpresa;
        Optional<Empresa> actualEmpresa = empresaRepositorio.findById(id);
        if(actualEmpresa.isPresent()) {
            pathEmpresa = actualEmpresa.get();
            pathEmpresa.setNombre(editarEmpresa.getNombre());
            pathEmpresa.setDireccion(editarEmpresa.getDireccion());
            pathEmpresa.setTelefono(editarEmpresa.getTelefono());
            pathEmpresa.setNit(editarEmpresa.getNit());
        } else {
            pathEmpresa = editarEmpresa;
        }
        return empresaRepositorio.save(pathEmpresa);
    }
}
