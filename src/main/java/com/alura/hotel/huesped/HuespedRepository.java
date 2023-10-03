package com.alura.hotel.huesped;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface HuespedRepository extends JpaRepository<Huesped,Long> {
    Page<Huesped> findByActivoTrue(Pageable paginacion);

    @Query("""
            select h.activo 
            from Huesped h
            where h.id=:idHuesped
            """)
    Boolean findActivoById(Long idHuesped);
}
