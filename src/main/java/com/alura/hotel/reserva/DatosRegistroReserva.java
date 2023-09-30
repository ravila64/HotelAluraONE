package com.alura.hotel.reserva;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public record DatosRegistroReserva(
        @NotNull
        @Future
        @DateTimeFormat(pattern = "dd/MM/yyyy")
        Date fechaE,
        @NotNull
        @Future
        @DateTimeFormat(pattern = "dd/MM/yyyy")
        Date fechaS,
        @NotNull
        String valor,
        @Enumerated(EnumType.STRING)
        FormaPago formaPago
) {
}
