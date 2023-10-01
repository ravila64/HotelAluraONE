create table huespedes(
    id bigint not null auto_increment,
	nombre varchar(80) not null,
	apellido varchar(80) not null,
	fecha_nacimiento date not null,
	nacionalidad varchar(50) not null,
	telefono varchar(30) not null,
	id_reserva int not null,
	primary key(id),
	// revisar mañana 01/oct
	constraint fk_huespedes_id_reserva foreign key(id_reserva) references reservas(id)
);