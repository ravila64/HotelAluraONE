package com.alura.hotel.reserva;

import java.util.Date;

public record DatosListadoReserva(Long id, Date fechaE, Date fechaS, float valor, String formaPago) {
    public DatosListadoReserva(Reserva reserva){
        this(reserva.getId(),reserva.getFechaE(), reserva.getFechaS(), reserva.getValor(), reserva.getFormaPago().toString());
    }
}
