package com.alura.hotel.reserva;

import com.alura.hotel.huesped.DatosActualizarHuesped;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

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
    private LocalDate fechaE=LocalDate.now();
    private LocalDate fechaS=LocalDate.now();
    private float valor;
    private String formaPago;
    private boolean activo;
    public Reserva(DatosRegistroReserva datosRegitroReserva){
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
