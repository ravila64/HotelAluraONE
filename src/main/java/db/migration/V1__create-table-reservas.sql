create table reservas(
    id int not null auto_increment,
    fechaE date not null,
    fechaS date not null,
    valor varchar(20) not null,
    formaPago varchar(30) not null,
    primary key(id)
);