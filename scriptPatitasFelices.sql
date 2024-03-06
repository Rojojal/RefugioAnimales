CREATE SCHEMA patitas_felices ;

create user 'usuario'@'%' identified by 'clave';

grant all privileges on patitas_felices.* to 'usuario'@'%';
flush privileges; /*para resfrescar privilegios inmediatamente*/

create table patitas_felices.mascotas (
  id_mascota INT NOT NULL AUTO_INCREMENT,
  animal VARCHAR(30) NOT NULL,
  genero VARCHAR(30) NOT NULL,
  raza VARCHAR(30) NOT NULL,
  nombre VARCHAR(30) NOT NULL,
  edad int,
  descripcion VARCHAR(1000) NOT NULL,
  ruta_imagen varchar(1024),
  activo bool,
  PRIMARY KEY (id_mascota));
  
  INSERT INTO patitas_felices.mascotas (id_mascota,animal,genero,raza,nombre,edad,descripcion,ruta_imagen,activo) VALUES 
('1','Perro','Hembra','Zaguate','Molly',2,'Una perrita muy social y dulce. Muy activa.','https://img.freepik.com/free-photo/cute-dog-waiting-be-adopted-by-someone_23-2148683001.jpg?t=st=1709617465~exp=1709621065~hmac=749370f07b3d7b7acf34447f9e32dec3fbc835a6cf37596847c433b8d1ec71b6&w=996.jpg',   true), 
('2', 'Gato', 'Macho', 'Siamés', 'Simba', 3, 'Un gatito muy juguetón y cariñoso. Le encanta explorar y buscar mimos.', 'https://img.freepik.com/free-photo/cute-cat-sitting-couch_23-2149078348.jpg?t=st=1709617732~exp=1709621332~hmac=13f3e1a5c88ee0ba4ba85fbf1f8d33409aa762d54c50025274cfbb9aa38c14a2&w=1380.jpg', true),
('3', 'Perro', 'Macho', 'Labrador', 'Galleta', 1, 'Un cachorro muy amigable y lleno de energía. Ideal para familias activas.', 'https://img.freepik.com/free-photo/beautiful-dog-labrador-lying-grass-with-orange-ball-sunset_8353-6476.jpg?t=st=1709618025~exp=1709621625~hmac=49849e207f7c8301f614971a2748f642cb227bbf7b8cb8159a285cf43198ed0a&w=1380.jpg', true);


  