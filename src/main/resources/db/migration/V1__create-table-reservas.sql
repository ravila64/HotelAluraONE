create table reservas(
    id bigint not null auto_increment,
    fecha_e date not null,
    fecha_s date not null,
    valor float not null,
    forma_pago varchar(30) not null,
    primary key(id)
);