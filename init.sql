-- init.sql
CREATE DATABASE IF NOT EXISTS base_empleados;
USE base_empleados;

CREATE TABLE IF NOT EXISTS usuario (
    id BIGINT NOT NULL AUTO_INCREMENT,
    comentario VARCHAR(255),
    nombre VARCHAR(255),
    parcelas INT,
    tiempo INT,
    PRIMARY KEY (id)
);
