create table reservas(
    id bigint not null auto_increment,
    fecha_entrada date not null,
    fecha_salida date not null,
    valor float not null,
    forma_pago varchar(30) not null,
    primary key(id)
);