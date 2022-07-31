
CREATE TABLE orgao_donatario (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255),
    endereco VARCHAR(255),
    telefone VARCHAR(16),
    horario_funcionamento VARCHAR(255),
    descricao VARCHAR(255)
);

CREATE TABLE orgao_fiscalizador (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255),
    descricao VARCHAR(255)
);

CREATE TABLE lote (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    data_entrega TIMESTAMP,
    observacao VARCHAR(255),
    id_orgao_donatario INT NOT NULL,
    id_orgao_fiscalizador INT NOT NULL,
    FOREIGN KEY (id_orgao_donatario) REFERENCES orgao_donatario(id),
    FOREIGN KEY (id_orgao_fiscalizador) REFERENCES orgao_fiscalizador(id)
);

CREATE TABLE produto (
    codigo INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255),
    descricao VARCHAR(255),
    id_lote INT NOT NULL,
    FOREIGN KEY (id_lote) REFERENCES lote (id)
);