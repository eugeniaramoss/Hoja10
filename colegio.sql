DROP DATABASE IF EXISTS colegio;
CREATE DATABASE IF NOT EXISTS colegio; 
USE colegio;

CREATE TABLE IF NOT EXISTS Alumnos (
  id_alum INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  nombre VARCHAR(30) NOT NULL,
  dni VARCHAR(9),
  edad INT,
  telefono INT,
  matricula INT,
  media INT, 
  grado VARCHAR(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS Aulas (
  id_aula INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  planta INT NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS Alumnos_has_Aulas (
    Alumnos_id_alum INT NOT NULL,
    Aulas_id_aula INT NOT NULL,
    profesor VARCHAR(30),
	asignatura VARCHAR(30) NOT NULL,
    FOREIGN KEY (Alumnos_id_alum) REFERENCES Alumnos (id_alum),
    FOREIGN KEY (Aulas_id_aula) REFERENCES Aulas (id_aula)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO Alumnos (id_alum, nombre, dni, edad, telefono, matricula, media, grado)
VALUES
  (1, 'Juan Pérez', '12345678A', 18, 123456789, 2021001, 8, '10º grado'),
  (2, 'María García', '98765432B', 17, 987654321, 2021002, 9, '10º grado'),
  (3, 'Pedro Rodríguez', '54321678C', 16, 987654321, 2021003, 7, '9º grado'),
  (4, 'Ana López', '87654321D', 17, 123456789, 2021004, 8, '11º grado'),
  (5, 'Carlos Martínez', '45678912E', 18, 987654321, 2021005, 9, '11º grado');

INSERT INTO Aulas (id_aula, planta)
VALUES
  (1, 1),
  (2, 2),
  (3, 1),
  (4, 3),
  (5, 2);

INSERT INTO Alumnos_has_Aulas (Alumnos_id_alum, Aulas_id_aula, profesor, asignatura)
VALUES
  (1, 1, 'Profesor 1', 'Matemáticas'),
  (2, 1, 'Profesor 2', 'Ciencias'),
  (3, 2, 'Profesor 3', 'Historia'),
  (4, 3, 'Profesor 4', 'Literatura'),
  (5, 2, 'Profesor 5', 'Inglés');
