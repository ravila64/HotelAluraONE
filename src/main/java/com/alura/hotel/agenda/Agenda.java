package com.alura.hotel.agenda;

import com.alura.hotel.huesped.Huesped;
import com.alura.hotel.reserva.Reserva;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "consultas")
@Entity(name = "Consulta")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Agenda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reserva_id")
    private Reserva reserva;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "huesped_id")
    private Huesped huesped;
    private LocalDateTime fecha;
    @Column(name="motivo_cancelamiento")
    @Enumerated(EnumType.STRING)
    private MotivoCancelamiento motivoCancelamiento;
    private boolean finalizada;

    public Agenda(Reserva reserva, Huesped huesped, LocalDateTime fecha) {
        this.reserva = reserva;
        this.huesped = huesped;
        this.fecha = fecha;
    }
    private void cancelar(MotivoCancelamiento motivo){
        this.motivoCancelamiento = motivo;
    }

    public void reservaFinalizada(){ this.finalizada = true; }

}
