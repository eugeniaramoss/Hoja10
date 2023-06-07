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

DROP USER 'eugenia'@'localhost';
CREATE USER 'eugenia'@'localhost' IDENTIFIED BY '123456';
GRANT ALL PRIVILEGES ON colegio.* TO 'eugenia'@'localhost';
-- FLUSH PRIVILEGES;
SHOW GRANTS FOR 'eugenia'@'localhost';