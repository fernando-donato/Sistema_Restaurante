
-- Criação do banco de dados
CREATE DATABASE IF NOT EXISTS restaurante_db
  CHARACTER SET utf8mb4
  COLLATE utf8mb4_unicode_ci;



-- Tabela clientes
DROP TABLE IF EXISTS clientes;
CREATE TABLE clientes (
  id_cliente INT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(100) NOT NULL,
  telefone VARCHAR(20),
  email VARCHAR(100),
  data_cadastro DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  ativo TINYINT(1) NOT NULL DEFAULT 1,
  PRIMARY KEY (id_cliente),
  UNIQUE KEY uk_email (email),
  INDEX idx_nome (nome)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Tabela funcionarios
-- Cria a tabela funcionarios
CREATE TABLE IF NOT EXISTS funcionarios (
  id_funcionarios INT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(100) NOT NULL,
  cpf VARCHAR(14) NOT NULL UNIQUE,
  cargo ENUM('Garçom', 'Cozinheiro', 'Gerente', 'Atendente') NOT NULL,
  horario_trabalho ENUM('Manhã (08:00-12:00)', 'Tarde (13:00-17:00)', 'Noite (18:00-22:00)', 'Integral (08:00-17:00)') NOT NULL,
  salario DECIMAL(10,2) NOT NULL,
  data_admissao DATE NOT NULL,
  PRIMARY KEY (id_funcionarios),
  INDEX idx_nome (nome)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
DESCRIBE pedidos;

-- Tabela pratos
DROP TABLE IF EXISTS pratos;
CREATE TABLE pratos (
  id_pratos INT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(100) NOT NULL,
  descricao TEXT NOT NULL,
  preco DECIMAL(10,2) NOT NULL,
  categoria ENUM('Entrada', 'Prato Principal', 'Sobremesa', 'Bebida') NOT NULL,
  PRIMARY KEY (id_pratos),
  INDEX idx_nome (nome),
  INDEX idx_categoria (categoria)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Tabela pedidos
DROP TABLE IF EXISTS pedidos;
CREATE TABLE pedidos (
  id_pedidos INT NOT NULL AUTO_INCREMENT,
  id_cliente INT NOT NULL,
  data_hora DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  status ENUM('Aberto', 'Em Andamento', 'Fechado', 'Cancelado') NOT NULL DEFAULT 'Aberto',
  PRIMARY KEY (id_pedidos),
  INDEX idx_status (status),
  FOREIGN KEY (id_cliente) REFERENCES clientes(id_cliente) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


-- Tabela itens_pedidos
DROP TABLE IF EXISTS itens_pedidos;
CREATE TABLE itens_pedidos (
  id_itens_pedidos INT NOT NULL AUTO_INCREMENT,
  id_pedidos INT NOT NULL,
  id_pratos INT NOT NULL,
  quantidade INT NOT NULL,
  PRIMARY KEY (id_itens_pedidos),
  FOREIGN KEY (id_pedidos) REFERENCES pedidos(id_pedidos) ON DELETE CASCADE ON UPDATE CASCADE,
  FOREIGN KEY (id_pratos) REFERENCES pratos(id_pratos) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Tabela usuarios
DROP TABLE IF EXISTS usuarios;
CREATE TABLE usuarios (
  id_usuario INT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(100) NOT NULL,
  usuario VARCHAR(50) NOT NULL UNIQUE,
  senha VARCHAR(255) NOT NULL,
  tipo ENUM('Administrador', 'Operador', 'Usuário') NOT NULL,
  PRIMARY KEY (id_usuario)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Inserção de dados
INSERT INTO clientes (nome, telefone, email) VALUES
('João Silva', '11999998888', 'joao.silva@email.com'),
('Maria Santos', '11888887777', 'maria.santos@email.com'),
('Carlos Pereira', '11777776666', 'carlos.pereira@email.com');

INSERT INTO funcionarios (nome, cpf, cargo, horario_trabalho, salario, data_admissao) VALUES
('Lucas Almeida', '123.456.789-00', 'Garçom', 'Manhã (08:00-12:00)', 1500.00, '2023-01-10'),
('Fernanda Costa', '987.654.321-00', 'Cozinheiro', 'Tarde (13:00-17:00)', 2000.00, '2022-05-20'),
('Ricardo Souza', '111.222.333-44', 'Gerente', 'Integral (08:00-17:00)', 3500.00, '2021-03-15');

INSERT INTO pratos (nome, descricao, preco, categoria) VALUES
('Salada Caesar', 'Alface, croutons, queijo parmesão e molho Caesar', 25.00, 'Entrada'),
('Filé Mignon ao Molho Madeira', 'Filé mignon grelhado com molho madeira e batatas sauté', 50.00, 'Prato Principal'),
('Pudim de Leite', 'Pudim de leite condensado com calda de caramelo', 15.00, 'Sobremesa'),
('Suco de Laranja', 'Suco natural de laranja', 8.00, 'Bebida');

INSERT INTO usuarios (nome, usuario, senha, tipo) VALUES
('Admin', 'admin', 'senha_hash_aqui', 'Administrador'),
('Operador1', 'operador1', 'senha_hash_aqui', 'Operador'),
('Usuario1', 'usuario1', 'senha_hash_aqui', 'Usuário');

INSERT INTO pedidos (id_cliente, data_hora, status) VALUES
(1, NOW(), 'Aberto'),
(2, NOW(), 'Aberto'),
(3, NOW(), 'Aberto');

INSERT INTO itens_pedidos (id_pedidos, id_pratos, quantidade) VALUES
(1, 1, 2),
(1, 2, 1),
(2, 3, 1),
(2, 4, 2),
(3, 2, 3);
