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

IF OBJECT_ID('Hilos.persona', 'U') IS NOT NULL
DROP TABLE Hilos.persona
GO
-- Create the table in the specified schema
CREATE TABLE Hilos.persona
(
    id INT NOT NULL PRIMARY KEY, -- primary key column
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
    id INT NOT NULL PRIMARY KEY, -- primary key column
    rol [NVARCHAR](50) NOT NULL
    -- specify more columns here
);
GO

use Hilos
GO

-- Create a new table called 'usuario' in schema 'SchemaName'
-- Drop the table if it already exists
IF OBJECT_ID('Hilos.usuario', 'U') IS NOT NULL
DROP TABLE Hilos.usuario
GO
-- Create the table in the specified schema
CREATE TABLE Hilos.usuario
(
    id INT NOT NULL PRIMARY KEY, -- primary key column
    personaid INT,
    usuario [NVARCHAR](25) NOT NULL,
    contrasena [NVARCHAR](25) NOT NULL,
    rolid INT,
    FOREIGN KEY (personaid) REFERENCES Hilos.persona(id),
    FOREIGN KEY (rolid) REFERENCES Hilos.roles(id)
    -- specify more columns here
);
GO

INSERT INTO Hilos.persona values(1,'JHOAN', 'SEBASTIAN', 'SAMAYOA', 'MAYEN', '78472210');
INSERT INTO Hilos.roles VALUES (1, 'ADMIN');
INSERT INTO Hilos.roles VALUES (2, 'USER');
INSERT INTO Hilos.usuario VALUES (1,1, 'jsamayoa', 'jsamayoa',1);

SELECT * FROM Hilos.persona;
SELECT * from Hilos.roles;

select * from Hilos.usuario;

