CREATE SCHEMA Hilos
GO

USE Hilos
GO

IF NOT EXISTS (
    SELECT name
        FROM sys.databases
        WHERE name = N'Hilos'
)
CREATE DATABASE Hilos
GO


USE Hilos
GO

IF OBJECT_ID('Hilos`.persona', 'U') IS NOT NULL
DROP TABLE Hilos.persona
GO
-- Create the table in the specified schema
CREATE TABLE Hilos.persona
(
    idpersona INT NOT NULL PRIMARY KEY, -- primary key column
    pnombre [NVARCHAR](50) NOT NULL,
    snombre [NVARCHAR](50) NULL,
    papellido [NVARCHAR](50) NOT NULL,
    sapellido [NVARCHAR](50) NULL,
    nit [NVARCHAR](50) NULL
    -- specify more columns here
);
GO

use Hilos
go

-- Create a new table called 'roles' in schema 'SchemaName'
-- Drop the table if it already exists
IF OBJECT_ID('Hilos.roles', 'U') IS NOT NULL
DROP TABLE Hilos.roles
GO
-- Create the table in the specified schema
CREATE TABLE Hilos.roles
(
    idrol INT NOT NULL PRIMARY KEY, -- primary key column
    rol [NVARCHAR](50) NOT NULL
    -- specify more columns here
);
GO


-- Create a new table called 'usuario' in schema 'SchemaName'
-- Drop the table if it already exists
IF OBJECT_ID('Hilos.usuario', 'U') IS NOT NULL
DROP TABLE Hilos.usuario
GO
-- Create the table in the specified schema
CREATE TABLE Hilos.usuario
(
    idusuario INT NOT NULL PRIMARY KEY, -- primary key column
    personaid INT,
    usuario [NVARCHAR](25) NOT NULL,
    contrasena [NVARCHAR](25) NOT NULL,
    rolid INT,
    FOREIGN KEY (personaid) REFERENCES Hilos.persona(idpersona),
    FOREIGN KEY (rolid) REFERENCES Hilos.roles(idrol)
    -- specify more columns here
);
GO

SELECT * FROM Hilos.persona;
