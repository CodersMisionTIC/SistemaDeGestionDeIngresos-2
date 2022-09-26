package com.Coders.Sprint3.Controlador;


import com.Coders.Sprint3.Entidades.Empleado;
import com.Coders.Sprint3.Entidades.Empresa;
import com.Coders.Sprint3.Servicio.EmpleadoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmpleadoControlador {

    @Autowired
    EmpleadoServicio empleadoServicio;

//muestra los empleados creados
    @GetMapping("/user")
    private List<Empleado> verEmpleado(){return empleadoServicio.verEmpleado();
    }

//Crea los empleados
    @PostMapping("/user")
    private void crearEmpleado(@RequestBody Empleado empleado){
        empleadoServicio.crearEmpleado(empleado);
    }

//Elimina a los empleados por su id
    @DeleteMapping("/user/{id}")
    private void eliminarEmpleado(@PathVariable("id") Integer id) {empleadoServicio.eliminarEmpleado(id);}

//muestra al el empleado por su id
    @GetMapping("/user/{id}")
    public Empleado consultarEmpleado(@PathVariable("id") Integer id){
        Optional<Empleado> consultarEmpleado = empleadoServicio.consultarEmpleado(id);
        return consultarEmpleado.isEmpty()? new Empleado() : consultarEmpleado.get();
    }

//actualiza los datos del empleado por su id
    @PatchMapping("/user/{id}")
    public Empleado actualizarEmpleado(@PathVariable("id") Integer id, @RequestBody Empleado editarEmpleado){
        return empleadoServicio.actualizarEmpleado(id, editarEmpleado);
    }

}
