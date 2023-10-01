alter table huespedes add activo tinyint;
update huespedes set activo=1;
alter table huespedes add finalizado tinyint;
update huespedes set finalizado=0;
