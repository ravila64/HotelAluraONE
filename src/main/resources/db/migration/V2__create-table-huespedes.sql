create table huespedes(
    id bigint not null auto_increment,
	nombre varchar(80) not null,
	apellido varchar(80) not null,
	fecha_nacimiento date not null,
	nacionalidad varchar(50) not null,
	telefono varchar(30) not null,
	id_reserva bigint not null,
	primary key(id)
);