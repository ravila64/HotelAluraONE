package com.alura.hotel.huesped;

import jakarta.validation.constraints.NotNull;

public record DatosActualizarHuesped(@NotNull Long id, String nombre, String apellido, String telefono) {

}
