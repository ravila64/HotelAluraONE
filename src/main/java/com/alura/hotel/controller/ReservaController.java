package com.alura.hotel.controller;

import io.swagger.v3.oas.annotations.Operation;
import com.alura.hotel.reserva.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/reservas")
public class ReservaController {
    @Autowired
    private ReservaRepository reservaRepository;

    @PostMapping
    @Transactional
    @Operation(summary = "Registra una nueva reserva en la base de datos")
    // registraReserva=GUARDAR()
    public void guardar(@RequestBody @Valid DatosRegistroReserva datosRegistroReserva){
        reservaRepository.save(new Reserva(datosRegistroReserva));
        System.out.println("El request llega correctamente RESERVAS");
        System.out.println(datosRegistroReserva);
    }
    @GetMapping
    @Operation(summary = "Obtiene el listado de Reservas")
    public Page<DatosListadoReserva> listadoReserva(@PageableDefault(size=2) Pageable paginacion ){
        return reservaRepository.findByActivoTrue(paginacion).map(DatosListadoReserva::new);
    }

    @GetMapping
    @Operation(summary = "Obtiene el listado de Reservas en una lista")
    public List<Reserva> getAll(){
        return reservaRepository.findAll();
    }

    @PutMapping
    @Transactional
    @Operation(summary = "Actualizar Reservas")
    public void actualizarReserva(@RequestBody @Valid DatosActualizarReserva datosActualizarReserva){
        Reserva reserva = reservaRepository.getReferenceById(datosActualizarReserva.id());
        reserva.actualizarDatos(datosActualizarReserva);
    }

    // DELETE LOGICO
    @DeleteMapping("/{id}")
    @Transactional
    @Operation(summary = "Elimina una reserva - inactivo")
    public ResponseEntity eliminarReserva(@PathVariable Long id) {
        Reserva reserva = reservaRepository.getReferenceById(id);
        reserva.desactivarReserva();
        return ResponseEntity.noContent().build();
    }


}
