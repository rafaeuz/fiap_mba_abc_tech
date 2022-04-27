CREATE TABLE assistances (
  id BIGINT AUTO_INCREMENT NOT NULL,
   name VARCHAR(100) NOT NULL,
   `description` VARCHAR(300) NOT NULL,
   CONSTRAINT pk_assistances PRIMARY KEY (id)
);

INSERT INTO assistances (name, description) VALUES ('Troca de aparelho', 'Troca de aparelho decodificador de sinal');
INSERT INTO assistances (name, description) VALUES ('Troca de cabo interno', 'Troca de cabo interno');
INSERT INTO assistances (name, description) VALUES ('Troca de fiação interna', 'Substituição de fiação interna da residência');
INSERT INTO assistances (name, description) VALUES ('Manutenção em fogão', 'Reparo sem necessidade de compra de peças');
INSERT INTO assistances (name, description) VALUES ('Manutenção em geladeira', 'Reparo sem necessidade de compra de peças');
INSERT INTO assistances (name, description) VALUES ('Manutenção em máquina de lavar', 'Reparo sem necessidade de compra de peças');
INSERT INTO assistances (name, description) VALUES ('Instalação de ar-condicionado', 'Instalação de aparelho de ar-condicionado adquirido pelo cliente');
INSERT INTO assistances (name, description) VALUES ('Troca de peças de geladeira', 'Reparo com necessidade de compra de peças');
INSERT INTO assistances (name, description) VALUES ('Troca de peças de fogão', 'Reparo com necessidade de compra de peças');
INSERT INTO assistances (name, description) VALUES ('Troca de peças de máquina de lavar', 'Reparo com necessidade de compra de peças');
INSERT INTO assistances (name, description) VALUES ('Limpeza de filtro de ar-condicionado', 'Limpeza e troca de filtros de ar');
INSERT INTO assistances (name, description) VALUES ('Limpeza de máquina de lavar', 'Limpeza com produto especializado');