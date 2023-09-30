create table agendas(
    id bigint not null auto_increment,
    reserva_id bigint not null,
    huesped_id bigint not null,
    fecha datetime not null,
    motivo_cancelamiento varchar(100) ,
    finalizada tinyint not null,
    primary key(id),

    constraint fk_agendas_reserva_id foreign key(reserva_id) references reservas(id),
    constraint fk_agendas_huesped_id foreign key(huesped_id) references huespedes(id)
);