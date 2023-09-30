package com.alura.hotel.controller;

import com.alura.hotel.huesped.DatosActualizarHuesped;
import com.alura.hotel.huesped.DatosListadoHuesped;
import com.alura.hotel.huesped.Huesped;
import com.alura.hotel.reserva.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reservas")
public class ReservaController {
    @Autowired
    private ReservaRepository reservaRepository;

    @PostMapping
    public void registraReserva(@RequestBody @Valid DatosRegistroReserva datosRegistroReserva){
        reservaRepository.save(new Reserva(datosRegistroReserva));
        System.out.println("El request llega correctamente RESERVAS");
        System.out.println(datosRegistroReserva);
    }
    @GetMapping
    public Page<DatosListadoReserva> listadoHuesped(@PageableDefault(size=2) Pageable paginacion ){
        return reservaRepository.findByActivoTrue(paginacion).map(DatosListadoReserva::new);
    }

    @PutMapping
    @Transactional
    public void actualizarReserva(@RequestBody @Valid DatosActualizarReserva datosActualizarReserva){
        Reserva reserva = reservaRepository.getReferenceById(datosActualizarReserva.id());
        reserva.actualizarDatos(datosActualizarReserva);
    }

}
