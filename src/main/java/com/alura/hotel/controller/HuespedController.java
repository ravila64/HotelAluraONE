package com.alura.hotel.controller;

import com.alura.hotel.huesped.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/huespedes")
public class HuespedController {
    @Autowired
    private HuespedRepository huespedRepository;

    @PostMapping
    public void registraHuesped(@RequestBody @Valid DatosRegistroHuesped datosRegistroHuesped){
        huespedRepository.save(new Huesped(datosRegistroHuesped));
        System.out.println("El request llega correctamente");
        System.out.println(datosRegistroHuesped);
    }

    @GetMapping
    public Page<DatosListadoHuesped> listadoHuesped(@PageableDefault(size=2) Pageable paginacion ){
        return huespedRepository.findByActivoTrue(paginacion).map(DatosListadoHuesped::new);
    }

    @PutMapping
    @Transactional
    public void actualizarHuesped(@RequestBody @Valid DatosActualizarHuesped datosActualizarHuesped){
        Huesped huesped = huespedRepository.getReferenceById(datosActualizarHuesped.id());
        huesped.actualizarDatos(datosActualizarHuesped);
    }
    // delete logico
    @DeleteMapping("/{id}")
    @Transactional
    public void eliminarHuesped(@PathVariable Long id ){
        Huesped huesped = huespedRepository.getReferenceById(id);
        huesped.desactivarHuesped();
    }

}
