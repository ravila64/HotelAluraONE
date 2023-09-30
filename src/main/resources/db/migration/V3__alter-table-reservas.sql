alter table reservas add activo tinyint;
update reservas set activo=1;
