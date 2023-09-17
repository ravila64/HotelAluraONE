create table huespedes(
    Id int not null auto_increment,
	Nombre varchar(80) not null,
	Apellido varchar(80) not null,
	FechaNacimiento date not null,
	Nacionalidad varchar(50) not null,
	Telefono varchar(30) not null,
	IdReserva int not null,
	primary key(Id),
	foreign key(IdReserva) references reservas(id)
);