DROP DATABASE IF EXISTS bd_blog2;
CREATE DATABASE bd_blog2 CHARACTER SET utf8 COLLATE utf8_general_ci;
use bd_blog2;

create table usuarios (
id int(11) unsigned auto_increment primary key,
usuario varchar(20) null,
password varchar(255) null
);

INSERT INTO usuarios (id, usuario, password) VALUES
(1, 'admin', '123'),
(2, 'usuario1', '123'),
(3, 'usuario2', '123');

create table posts (
id int(11) unsigned auto_increment primary key,
fecha date null,
titulo varchar(255) null,
contenido text null,
id_usuario int(11) not null	
);

INSERT INTO posts (id, fecha, titulo, contenido, id_usuario) VALUES
(1, '2021-05-02', 'La belleza oculta de calcular costos de salud2', 'Que servicios de salud deben estar disponibles y en que condiciones? Esto es una pregunta clave para todos los paises que quieren avanzar hacia la CUS (cobertura universal de salud). Y los paquetes de beneficios para la salud (HBPs) son una respuesta a esta pregunta, ya que se refieren a una definicion explicita de los servicios que pueden financiarse y prestarse en las circunstancias reales en las que un pais determinado se encuentra. ', 2),
(2, '2021-05-04', 'Como adelgazar mejora tu sistema digestivo', 'Autoedicion y editores de pagina web usan el Lorem Ipsum como su texto por defecto, y al hacer una busqueda de \"Lorem Imsum\" va dar como resultado muchos sitios web. ', 1),
(3, '2021-05-07', 'Modelo conputacional que puso al mundo en cuarentena', 'Autoedicion y editores de pagina web usan el Lorem Ipsum como su texto por defecto, y al hacer una busqueda de \"Lorem Imsum\" va dar como resultado muchos sitios web. ', 1);


