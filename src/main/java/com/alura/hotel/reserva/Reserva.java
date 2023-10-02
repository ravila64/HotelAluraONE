package com.alura.hotel.reserva;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.util.Date;

@Entity(name = "Reserva")
@Table(name = "reservas")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Reserva {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY )
    private Long id;
    private Date fechaE;
    private Date fechaS;
    //private java.util.@NotNull @Future Date fechaE= valueOf(LocalDate.now());
    //private java.util.@NotNull @Future Date fechaS= valueOf(LocalDate.now().plusDays(5));
    private float valor;
    private String formaPago;
    private boolean activo;
    public Reserva(DatosRegistroReserva datosRegitroReserva){
        this.activo=true;
        this.fechaE=datosRegitroReserva.fechaE();
        this.fechaS=datosRegitroReserva.fechaS();
        this.valor=datosRegitroReserva.valor();
        this.formaPago = datosRegitroReserva.formaPago();
    }

    public void actualizarDatos(DatosActualizarReserva datosActualizarReserva){
        if(datosActualizarReserva.valor().toString()!=null){
            this.valor = Float.parseFloat(datosActualizarReserva.valor());
        }
        if(datosActualizarReserva.formaPago()!=null){
            this.formaPago = datosActualizarReserva.formaPago().toString();
        }
    }

    public void desactivarReserva() {
        this.activo = false;
    }

}
