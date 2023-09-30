package com.alura.hotel.huesped;

public record DatosListadoHuesped(Long id, String nombre, String apellido, String nacionalidad, String telefono, Long idReserva) {
    public DatosListadoHuesped(Huesped huesped){
        this(huesped.getId(), huesped.getNombre(), huesped.getApellido(),huesped.getNacionalidad().toString(),huesped.getTelefono(), Long.valueOf(huesped.getIdReserva()));

   }
}
