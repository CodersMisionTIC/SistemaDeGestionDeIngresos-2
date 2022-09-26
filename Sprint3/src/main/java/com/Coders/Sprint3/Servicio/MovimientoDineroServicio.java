package com.Coders.Sprint3.Servicio;


import com.Coders.Sprint3.Entidades.Empresa;
import com.Coders.Sprint3.Entidades.MovimientoDinero;
import com.Coders.Sprint3.Repositorio.MovimientoDineroRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MovimientoDineroServicio {

    @Autowired
    MovimientoDineroRepositorio movimientoDineroRepositorio;

    //Consultar todos los movimientos creados
    public List<MovimientoDinero> consultarMovimientos() {
        return movimientoDineroRepositorio.findAll();
    }


    //consultar todos los movimientos de dinero de una empresa
    public Optional<MovimientoDinero> consultarMovimientos(Integer id) {
        return movimientoDineroRepositorio.findById(id);
    }

    //Consultar movimiento de dinero por Id
    public Optional<MovimientoDinero> consultarMovimiento(Integer id) {
        return movimientoDineroRepositorio.findById(id);}

    //Guardar nuevo movimiento
    public Boolean guardarMovimiento(MovimientoDinero movimientoDinero){
         MovimientoDinero move=movimientoDineroRepositorio.save(movimientoDinero);
        if(movimientoDineroRepositorio.findById(move.getId())!=null){
            return true;
        }
        return false;
    }

    //Actualizar información de movimiento (Monto, Concepto)
    public MovimientoDinero actualizarMovimiento(Integer id, MovimientoDinero editarMovimiento) {
        MovimientoDinero pathMovimiento;
        Optional<MovimientoDinero> actualMovimiento = movimientoDineroRepositorio.findById(id);
        if(actualMovimiento.isPresent()) {
            pathMovimiento = actualMovimiento.get();
            pathMovimiento.setUsuarioMovimiento(editarMovimiento.getUsuarioMovimiento());
            pathMovimiento.setConceptoMovimiento(editarMovimiento.getConceptoMovimiento());
            pathMovimiento.setMontoMovimiento(editarMovimiento.getMontoMovimiento());

        } else {
            pathMovimiento = editarMovimiento;
        }
        return movimientoDineroRepositorio.save(pathMovimiento);
    }



    //Eliminar movimiento
    @Transactional
    public boolean borrarMovimiento(Integer id) {
        movimientoDineroRepositorio.deleteById(id);
        if (this.movimientoDineroRepositorio.findById(id).isPresent()) {
            return false;
        }
        return true;
    }


}
