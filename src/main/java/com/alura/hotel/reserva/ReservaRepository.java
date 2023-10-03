package com.alura.hotel.reserva;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {
    Page<Reserva> findByActivoTrue(Pageable paginacion);

    @Query("""
            select r.activo 
            from Reserva r
            where r.id=:idReserva
            """)
    Boolean findActivoById(Long idReserva);

//    public List<jdbc.modelo.Reserva> buscar() {
//        List<jdbc.modelo.Reserva> reservas = new ArrayList<jdbc.modelo.Reserva>();
//        try {
//            String sql = "SELECT id, fecha_entrada, fecha_salida, valor, forma_pago FROM reservas";
//
//            try (PreparedStatement pstm = connection.prepareStatement(sql)) {
//                pstm.execute();
//
//                transformarResultSetEnReserva(reservas, pstm);
//            }
//            return reservas;
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
}
