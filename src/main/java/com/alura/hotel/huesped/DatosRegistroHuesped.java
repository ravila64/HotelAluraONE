package com.alura.hotel.huesped;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;

public record DatosRegistroHuesped(
        @NotBlank
        String nombre,
        @NotBlank
        String apellido,
        @NotNull
        @Future
        @DateTimeFormat(pattern = "dd/MM/yyyy")
        Date fechaNacimiento,
        @Enumerated(EnumType.STRING)
        Nacionalidad nacionalidad,
        @NotBlank
        String telefono,
        @NotNull
        Integer idReserva
) {
}
