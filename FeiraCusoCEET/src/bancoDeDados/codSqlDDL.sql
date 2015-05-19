create database if not exists feira_de_curso;
use feira_de_curso;
create table if not exists aluno (
codAluno int unsigned not null auto_increment,
nome varchar(80),
primary key (codAluno)
);
create table if not exists convidado (
codAluno int unsigned not null,
nome varchar(80) not null,
cpf varchar (11) not null,
email varchar(90),
escolaridade varchar(20),
telefone varchar(12),
foreign key (codAluno) references aluno (codAluno),
primary key (cpf)
);
