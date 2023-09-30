package com.alura.hotel.reserva;

import jakarta.validation.constraints.NotNull;

public record DatosActualizarReserva(@NotNull Long id, String valor, FormaPago formaPago ) {
}
