package com.Coders.Sprint3.Controlador;

import com.Coders.Sprint3.Entidades.MovimientoDinero;
import com.Coders.Sprint3.Servicio.MovimientoDineroServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class MovimientoDineroControlador {

    @Autowired
    MovimientoDineroServicio movimientoDineroServicio;

    @GetMapping("/movimiento")
    private List<MovimientoDinero> verMovimiento() {
        return movimientoDineroServicio.consultarMovimientos();
    }

    @PostMapping("/movimiento")
    private void crearMovimientos(@RequestBody MovimientoDinero movimientoDinero) {
        movimientoDineroServicio.guardarMovimiento(movimientoDinero);
    }

    @DeleteMapping("/movimiento/{id}")
    private void eliminarMovimientos(@PathVariable("id") Integer id) {
        movimientoDineroServicio.borrarMovimiento(id);
    }

//actualiza los datos del empleado por su id
    @PatchMapping("/movimiento/{id}")
    public MovimientoDinero actualizarMovimiento(@PathVariable("id") Integer id, @RequestBody MovimientoDinero editarMovimiento) {
        return movimientoDineroServicio.actualizarMovimiento(id, editarMovimiento);
    }

//Consultar todos los movimientos según la empresal
    @GetMapping("/movimiento/{id}")
    public MovimientoDinero consultarMovimiento(@PathVariable("id") Integer id){
        Optional<MovimientoDinero> consultarMovimiento = movimientoDineroServicio.consultarMovimiento(id);
        return consultarMovimiento.isEmpty()? new MovimientoDinero() : consultarMovimiento.get();
    }
}
