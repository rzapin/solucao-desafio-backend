CREATE TABLE IF NOT EXISTS AMIGO
(
    ID             NUMBER NOT NULL,
    NOME           VARCHAR2(32),
    VALOR_TOTAL    NUMBER,
    ID_TRANSACAO   NUMBER,
    PRIMARY KEY (ID)
);

MERGE INTO AMIGO (ID, NOME, VALOR_TOTAL, ID_TRANSACAO) VALUES (3, 'EU', 31.92, 1);
MERGE INTO AMIGO (ID, NOME, VALOR_TOTAL, ID_TRANSACAO) VALUES (4, 'AMIGO', 6.08, 1);