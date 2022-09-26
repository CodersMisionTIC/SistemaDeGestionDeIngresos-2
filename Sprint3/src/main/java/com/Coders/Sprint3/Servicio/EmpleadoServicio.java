package com.Coders.Sprint3.Servicio;

import com.Coders.Sprint3.Entidades.Empleado;
import com.Coders.Sprint3.Entidades.Empresa;
import com.Coders.Sprint3.Repositorio.EmpleadoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoServicio {

    @Autowired
    EmpleadoRepositorio empleadoRepositorio;

  //crea un empleado
    public void crearEmpleado(Empleado empleado){
        empleadoRepositorio.save(empleado);

    }
//muestra todos los empleados
    public List<Empleado> verEmpleado(){
        List<Empleado> empleados = new ArrayList<Empleado>();
        empleados.addAll(empleadoRepositorio.findAll());
        return empleados;
    }

//elimina a un empleado por su id
    public void eliminarEmpleado(Integer id){
        empleadoRepositorio.deleteById(id);
    }

//consuita a un empleado por su id
public Optional<Empleado> consultarEmpleado(Integer id) {
    return empleadoRepositorio.findById(id);}

//actualiza empleado por su id
public Empleado actualizarEmpleado(Integer id, Empleado editarEmpleado) {
    Empleado pathEmplado;
    Optional<Empleado> actualEmpleado = empleadoRepositorio.findById(id);
    if(actualEmpleado.isPresent()) {
        pathEmplado = actualEmpleado.get();
        pathEmplado.setNombre(editarEmpleado.getNombre());
        pathEmplado.setEmail(editarEmpleado.getEmail());
        pathEmplado.setEmpresaVinculada(editarEmpleado.getEmpresaVinculada());
        pathEmplado.setRolEmpleado(editarEmpleado.getRolEmpleado());
    } else {
        pathEmplado = editarEmpleado;
    }
    return empleadoRepositorio.save(pathEmplado);
}



}
