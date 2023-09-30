package com.alura.hotel.huesped;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Table(name="huespedes")
@Entity(name="Huesped")
@Getter
@NoArgsConstructor
@EqualsAndHashCode(of="id")
public class Huesped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellido;
    private Date fechaNacimiento;
    @Enumerated(EnumType.STRING)
    private Nacionalidad nacionalidad;
    private String telefono;
    private Integer idReserva;

    public Huesped(DatosRegistroHuesped datosRegistroHuesped){
        this.activo=true;
        this.nombre = datosRegistroHuesped.nombre();
        this.apellido=datosRegistroHuesped.apellido();
        this.fechaNacimiento=datosRegistroHuesped.fechaNacimiento();
        this.nacionalidad=datosRegistroHuesped.nacionalidad();
        this.telefono= datosRegistroHuesped.telefono();
        this.idReserva = datosRegistroHuesped.idReserva();
    }

}