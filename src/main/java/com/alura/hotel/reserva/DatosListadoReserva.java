package com.alura.hotel.reserva;

import java.time.LocalDate;

public record DatosListadoReserva(Long id, LocalDate fechaE, LocalDate fechaS, float valor, String formaPago) {
    public DatosListadoReserva(Reserva reserva){
        this(reserva.getId(),reserva.getFechaE(), reserva.getFechaS(), reserva.getValor(), reserva.getFormaPago().toString());
    }
}
