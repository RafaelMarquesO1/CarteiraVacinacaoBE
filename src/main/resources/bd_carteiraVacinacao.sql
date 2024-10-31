-- DROP DATABASE bd_carteiraVacinacao
USE master;
IF EXISTS (
    SELECT * FROM SYS.databases
    WHERE name = 'bd_carteiraVacinacao'
)
BEGIN
    DROP DATABASE bd_carteiraVacinacao;
END
GO

CREATE DATABASE bd_carteiraVacinacao;
GO
USE bd_carteiraVacinacao;
GO

-- Tabela Funcionario
CREATE TABLE Funcionario (
    id          INT             IDENTITY,
    nome        VARCHAR(60)     NOT NULL,
    email       VARCHAR(50)     NOT NULL UNIQUE,
    senha       VARCHAR(255)    NOT NULL,

    PRIMARY KEY(id)
);
GO

INSERT INTO Funcionario (nome, email, senha)
VALUES ('João da Silva', 'joao.silva@email.com', 'senha123');

INSERT INTO Funcionario (nome, email, senha)
VALUES ('Maria Oliveira', 'maria.oliveira@email.com', 'senhaSegura456');

INSERT INTO Funcionario (nome, email, senha)
VALUES ('Pedro Santos', 'pedro.santos@email.com', 'senhaForte789');




-- Tabela Paciente
CREATE TABLE Paciente (
    id          INT             IDENTITY,
    nome        VARCHAR(100)    NOT NULL,
    telefone    VARCHAR(20)			NULL,
    genero      CHAR(1)				NULL,   -- M para Masculino, F para Feminino, O para Outro
    dataNasc    DATE				NULL,
    endereco    VARCHAR(100)		NULL,
    cpf         CHAR(11)        NOT NULL UNIQUE,  -- CPF deve ser único

    PRIMARY KEY(id)
);
GO

INSERT INTO Paciente (nome, telefone, genero, dataNasc, endereco, cpf)
VALUES ('Ana Souza', '(11) 91234-5678', 'F', '1990-03-15', 'Rua das Flores, 123, São Paulo', '12345678901');

INSERT INTO Paciente (nome, telefone, genero, dataNasc, endereco, cpf)
VALUES ('Carlos Pereira', '(21) 99876-5432', 'M', '1985-07-22', 'Av. Paulista, 987, Rio de Janeiro', '98765432100');

INSERT INTO Paciente (nome, telefone, genero, dataNasc, endereco, cpf)
VALUES ('Patrícia Costa', NULL, 'F', '1995-11-10', 'Rua Verde, 56, Curitiba', '11223344556');




-- Tabela Vacinas (Relacionada à Carteirinha)
CREATE TABLE Vacinas (
    id              BIGINT          IDENTITY,
    nomeVacina      VARCHAR(50)     NOT NULL,
    lote            VARCHAR(150)    NOT NULL,
    vacStatus       VARCHAR(10)     NOT NULL,   -- Status da vacina (ATIVO/INATIVO)

    PRIMARY KEY(id)
);
GO

-- Tabela Campanha
CREATE TABLE Campanha (
    id              BIGINT          IDENTITY,
    nomeCampanha    VARCHAR(100)	NOT NULL,
    descricao       VARCHAR(500)		NULL,
    dataInicio      DATE				NULL,
    dataFim         DATE				NULL,

    PRIMARY KEY(id)
);
GO

SELECT * FROM Funcionario
SELECT * FROM Campanha
SELECT * FROM Vacinas
SELECT * FROM Paciente