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
@Table(name = "empleado")

public class Empleado {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "nombre")
    private String nombre;
    private String email;
    private String empresaVinculada;
    private String rolEmpleado;
    @OneToMany(mappedBy = "empleado")
    private List<MovimientoDinero> movimientos;
    @ManyToOne
    @JoinColumn(name = "empresa_empleado")
    private Empresa empresa;

}
