package com.Coders.Sprint3.Entidades;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "empresa")

public class Empresa {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "nombre")
    private String nombre;
    private String direccion;
    private Integer telefono;
    private Integer nit;
    @OneToMany(mappedBy = "empresa")
    private List<MovimientoDinero> movimientos;

    @OneToMany(mappedBy = "empresa")
    private List<Empleado> empleados;
}
