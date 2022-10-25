CREATE TABLE IF NOT EXISTS PRODUTO
(
    ID             NUMBER NOT NULL,
    NOME           VARCHAR2(32),
    AMIGO          VARCHAR2(32),
    VALOR          NUMBER,
    ID_TRANSACAO   NUMBER,
    PRIMARY KEY (ID)
);

MERGE INTO PRODUTO (ID, NOME, AMIGO, VALOR, ID_TRANSACAO) VALUES (2, 'SANDUICHE', 'AMIGO', 40.0, 1);
MERGE INTO PRODUTO (ID, NOME, AMIGO, VALOR, ID_TRANSACAO) VALUES (3, 'REFRI', 'AMIGO', 2.0,  1);