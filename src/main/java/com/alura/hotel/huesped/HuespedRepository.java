package com.alura.hotel.huesped;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HuespedRepository extends JpaRepository<Huesped,Long> {
    Page<Huesped> findByActivoTrue(Pageable paginacion);
}
