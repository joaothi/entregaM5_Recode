/* Logico_JT_VIagensCerto: */
use jt_viagensAgencia3;

/* Logico_JT_VIagensCerto: */
use  jt_viagensAgencia3;

    CREATE TABLE Cliente (
    Cpf VARCHAR(11),
    Nome VARCHAR(100),
    Endereco VARCHAR(70),
    Idade VARCHAR(99),
    IdCliente INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT
);


CREATE TABLE ItemCompra (
    IdItemCompra INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
    IdPacote INTEGER,
    CONSTRAINT fk_Pacote_IdPacote foreign key (IdPacote) references Pacote (IdPacote),
    idCompra INTEGER,
    CONSTRAINT fk_Compra_IdCompra FOREIGN KEY (IdCompra) references Compra (idCompra)
    
);

    CREATE TABLE Pacote (
    IdPacote INTEGER NOT NULL PRIMARY KEY auto_increment,
    Preco FLOAT,
    Destino VARCHAR(50),
    DataViagem VARCHAR(11),
    Hora VARCHAR(10)
);

	CREATE TABLE Compra (
    IdCompra INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
    Valor FLOAT,
    Data DATE,
    IdCliente INTEGER,
    CONSTRAINT fk_Cliente_idCliente foreign key (IdCliente) references Cliente (idCliente)
    );
   