package com.Coders.Sprint3.Entidades;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "movimieto_dinero")
public class MovimientoDinero {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "concepto_movimiento")
    private String conceptoMovimiento;
    private Double montoMovimiento;
    private String usuarioMovimiento;
    @ManyToOne
    @JoinColumn(name = "empleado_movimiento")
    private Empleado empleado;
    @ManyToOne
    @JoinColumn(name = "empresa_movimiento")
    private Empresa empresa;


}
