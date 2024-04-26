-- Database
CREATE DATABASE avisApi;

-- Client table
CREATE TABLE client (
    id integer primary key not null AUTO_INCREMENT,
    email varchar(50)
);

-- Mise a jour du client
ALTER TABLE Client
ADD COLUMN telephone varchar(15);

-- Table sentiment
CREATE TABLE sentiment(
    id integer primary key not null AUTO_INCREMENT,
    texte varchar(50),
    type varchar(10),
    clientId integer,
    CONSTRAINT client_fk FOREIGN KEY(clientId) REFERENCES client(id)
);