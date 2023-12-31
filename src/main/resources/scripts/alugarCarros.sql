drop schema alugarCarros;

create schema alugarCarros;
use alugarCarros;

create table alugarCarros.usuarios (
	id int auto_increment not null,
    nome varchar(100) not null,
    dt_nascimento date not null,
    cpf char(11) not null,
    cnh char(11) not null,
    constraint usuarios_pk primary key(id)
);

create table alugarCarros.carros (
	id int auto_increment not null,
    fabricante varchar(100) not null,
    modelo varchar(100) not null,
    tipo varchar(100) not null,
    placa varchar(7) not null,
    cor varchar(50) not null,
    valor_semanal double not null,
    disponivel boolean not null,
    id_usuario int,
    constraint carros_pk primary key(id),
    constraint id_usuario foreign key (id_usuario) references alugarCarros.usuarios(id)
);

insert into alugarCarros.carros (fabricante, modelo, tipo, placa, cor, valor_semanal, disponivel)
values ('BMW', 'I8', 'Luxo', 'ABC1234', 'Preto', 400, true);

insert into alugarCarros.carros (fabricante, modelo, tipo, placa, cor, valor_semanal, disponivel, id_usuario)
values ('BMW', 'I8', 'Luxo', 'ABC1234', 'Preto', 400, true, 1);

insert into alugarCarros.usuarios(nome, dt_nascimento, cpf, cnh)
values ('Arthur', '2003-09-10', 11747407950, 12345678910);

select * from alugarCarros.carros;
select * from alugarCarros.usuarios;