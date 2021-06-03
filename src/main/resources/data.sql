DROP TABLE IF EXISTS COIN;
CREATE TABLE COIN (
    id INT AUTO_INCREMENT PRIMARY KEY,
    value INT NOT NULL,
    symbol VARCHAR(2) NOT NULL
);

INSERT INTO COIN(value,symbol) VALUES
(6,'$'),
(5,'$'),
(4,'$'),
(3,'$'),
(1,'$');