create database matchmaker;

use matchmaker;

create table Perfil(
  id bigint primary key auto_increment,
  nombre varchar(100) not null,
  apellidoPaterno varchar(100) not null,
  apellidoMaterno varchar(100) not null,
  fechaDeNacimiento date not null,
  foto varchar(255) not null,
  email varchar(155) not null,
  genero varchar(15) not null,
  pais varchar(100) not null,
  telefono varchar(18) not null,
  celular varchar(18) not null,
  direccion varchar(250) not null,
  edad int not null
);