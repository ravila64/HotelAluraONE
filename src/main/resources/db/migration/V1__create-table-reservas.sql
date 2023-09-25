create table reservas(
    id int not null auto_increment,
    fecha_e date not null,
    fecha_s date not null,
    valor varchar(20) not null,
    forma_pago varchar(30) not null,
    primary key(id)
);