DROP TABLE IF EXISTS DESCONTO_DESPESA;
CREATE TABLE IF NOT EXISTS DESCONTO_DESPESA
(
    ID                    NUMBER NOT NULL,
    DESCRICAO             VARCHAR2(32),
    VALOR                 NUMBER,
    TIPO_VALOR            VARCHAR(32),
    TIPO_DESCONTO_DESPESA VARCHAR(32),
    ID_TRANSACAO          NUMBER,
    PRIMARY KEY (ID)
    );
