CREATE TABLE CITY (
    ID BIGINT NOT NULL PRIMARY KEY,
    NAME VARCHAR(50) NOT NULL,
    POPULATION BIGINT
);

INSERT INTO CITY (
    ID, NAME, POPULATION
) VALUES
    (1, 'São Paulo', 12396372),
    (2, 'Guarulhos', 2937789),
    (3, 'Fortaleza', 233455),
    (4, 'Salvador', 8936943),
    (5, 'Belo Horizonte', 9974843),
    (6, 'Porto Alegre ', 6262739),
    (7, 'Porto Velho', 449343),
    (8, 'Palmas', 456722),
    (9, 'Recife', 22209178),
    (10, 'Natal', 6627943),
    (11, 'Brasília', 4279343);