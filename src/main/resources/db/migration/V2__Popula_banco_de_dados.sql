-- Insere clientes
INSERT INTO db_soat.tb_cliente (id_cliente, nome, data_cadastro, email, cpf) VALUES(1, 'GUEST', '2024-01-31 20:59:40', 'guest@shogunlanches.com', '57209668039');
INSERT INTO db_soat.tb_cliente (id_cliente, nome, data_cadastro, email, cpf) VALUES(2, 'Rodrigo', '2024-05-16 20:03:21', 'rodrigo@hotmail.com', '02581635002');
INSERT INTO db_soat.tb_cliente (id_cliente, nome, data_cadastro, email, cpf) VALUES(3, 'Jane', '2024-05-26 21:00:02', 'jane@hotmail.com', '02781593036');
INSERT INTO db_soat.tb_cliente (id_cliente, nome, data_cadastro, email, cpf) VALUES(4, 'Pedro', '2024-05-26 21:00:22', 'pedro@hotmail.com', '96382852066');
INSERT INTO db_soat.tb_cliente (id_cliente, nome, data_cadastro, email, cpf) VALUES(5, 'Igor', '2024-05-26 21:00:49', 'igor@hotmail.com', '13407834012');
INSERT INTO db_soat.tb_cliente (id_cliente, nome, data_cadastro, email, cpf) VALUES(6, 'Maria', '2024-05-26 21:01:21', 'maria@hotmail.com', '81818766019');


-- Insere produtos no banco
INSERT INTO db_soat.tb_produto (id_produto, categoria, nome, valor, status) VALUES (1, 'bebida', 'coca-cola', 5.00, 1);
INSERT INTO db_soat.tb_produto (id_produto, categoria, nome, valor, status) VALUES (2, 'bebida', 'guarana', 5.00, 1);
INSERT INTO db_soat.tb_produto (id_produto, categoria, nome, valor, status) VALUES (3, 'acompanhamento', 'fritas', 7.00, 1);
INSERT INTO db_soat.tb_produto (id_produto, categoria, nome, valor, status) VALUES (4, 'lanche', 'cheese burguer da casa', 10.00, 1);
INSERT INTO db_soat.tb_produto (id_produto, categoria, nome, valor, status) VALUES(5, 'sobremesa', 'torta de maçã', 6.00, 1);
INSERT INTO db_soat.tb_produto (id_produto, categoria, nome, valor, status) VALUES(11, 'bebida', 'fanta uva', 5.00, 1);
INSERT INTO db_soat.tb_produto (id_produto, categoria, nome, valor, status) VALUES(12, 'bebida', 'fanta laranja', 5.00, 1);
INSERT INTO db_soat.tb_produto (id_produto, categoria, nome, valor, status) VALUES(13, 'bebida', 'sprite', 5.00, 1);
INSERT INTO db_soat.tb_produto (id_produto, categoria, nome, valor, status) VALUES(14, 'bebida', 'h2o', 5.00, 1);
INSERT INTO db_soat.tb_produto (id_produto, categoria, nome, valor, status) VALUES(15, 'acompanhamento', 'fritas com bacon', 10.00, 1);
INSERT INTO db_soat.tb_produto (id_produto, categoria, nome, valor, status) VALUES(16, 'acompanhamento', 'onion rings', 12.00, 1);
INSERT INTO db_soat.tb_produto (id_produto, categoria, nome, valor, status) VALUES(17, 'lanche', 'x-salada com bacon', 12.00, 1);
INSERT INTO db_soat.tb_produto (id_produto, categoria, nome, valor, status) VALUES(18, 'lanche', 'duplo cheese burguer da casa', 15.00, 1);
INSERT INTO db_soat.tb_produto (id_produto, categoria, nome, valor, status) VALUES(19, 'lanche', 'x-bacon especial', 15.00, 1);
INSERT INTO db_soat.tb_produto (id_produto, categoria, nome, valor, status) VALUES(20, 'lanche', 'x-tudo da casa', 20.00, 1);
INSERT INTO db_soat.tb_produto (id_produto, categoria, nome, valor, status) VALUES(21, 'sobremesa', 'pudim de leite', 7.00, 1);
INSERT INTO db_soat.tb_produto (id_produto, categoria, nome, valor, status) VALUES(22, 'sobremesa', 'salada de frutas', 7.00, 1);
INSERT INTO db_soat.tb_produto (id_produto, categoria, nome, valor, status) VALUES(23, 'sobremesa', 'sorvete', 8.00, 1);

-- Insere pedidos
INSERT INTO db_soat.tb_pedido (numero_pedido, data_pedido, valor_total, etapa, id_cliente, id_pagamento, data_mudanca_etapa) VALUES(15, '2024-05-28 00:15:01', 53.00, 'RECEBIDO', 1, NULL, NULL);
INSERT INTO db_soat.tb_pedido (numero_pedido, data_pedido, valor_total, etapa, id_cliente, id_pagamento, data_mudanca_etapa) VALUES(16, '2024-05-28 00:17:39', 34.00, 'RECEBIDO', 4, NULL, NULL);
INSERT INTO db_soat.tb_pedido (numero_pedido, data_pedido, valor_total, etapa, id_cliente, id_pagamento, data_mudanca_etapa) VALUES(17, '2024-05-28 00:19:27', 33.00, 'RECEBIDO', 2, NULL, NULL);
INSERT INTO db_soat.tb_pedido (numero_pedido, data_pedido, valor_total, etapa, id_cliente, id_pagamento, data_mudanca_etapa) VALUES(18, '2024-05-28 00:20:42', 37.00, 'RECEBIDO', 3, NULL, NULL);
INSERT INTO db_soat.tb_pedido (numero_pedido, data_pedido, valor_total, etapa, id_cliente, id_pagamento, data_mudanca_etapa) VALUES(19, '2024-05-28 00:21:13', 20.00, 'RECEBIDO', 6, NULL, NULL);
INSERT INTO db_soat.tb_pedido (numero_pedido, data_pedido, valor_total, etapa, id_cliente, id_pagamento, data_mudanca_etapa) VALUES(20, '2024-05-28 00:39:58', 25.00, 'RECEBIDO', 3, NULL, NULL);

-- Insere composicao
INSERT INTO db_soat.tb_composicao_pedido (id_composicao, id_produto, quantidade, preco_unitario, numero_pedido) VALUES(5, 1, 1, 5.00, 15);
INSERT INTO db_soat.tb_composicao_pedido (id_composicao, id_produto, quantidade, preco_unitario, numero_pedido) VALUES(6, 5, 1, 6.00, 15);
INSERT INTO db_soat.tb_composicao_pedido (id_composicao, id_produto, quantidade, preco_unitario, numero_pedido) VALUES(7, 20, 1, 20.00, 15);
INSERT INTO db_soat.tb_composicao_pedido (id_composicao, id_produto, quantidade, preco_unitario, numero_pedido) VALUES(8, 15, 1, 10.00, 15);
INSERT INTO db_soat.tb_composicao_pedido (id_composicao, id_produto, quantidade, preco_unitario, numero_pedido) VALUES(9, 16, 1, 12.00, 15);
INSERT INTO db_soat.tb_composicao_pedido (id_composicao, id_produto, quantidade, preco_unitario, numero_pedido) VALUES(10, 2, 1, 5.00, 16);
INSERT INTO db_soat.tb_composicao_pedido (id_composicao, id_produto, quantidade, preco_unitario, numero_pedido) VALUES(11, 15, 1, 10.00, 16);
INSERT INTO db_soat.tb_composicao_pedido (id_composicao, id_produto, quantidade, preco_unitario, numero_pedido) VALUES(12, 17, 1, 12.00, 16);
INSERT INTO db_soat.tb_composicao_pedido (id_composicao, id_produto, quantidade, preco_unitario, numero_pedido) VALUES(13, 22, 1, 7.00, 16);
INSERT INTO db_soat.tb_composicao_pedido (id_composicao, id_produto, quantidade, preco_unitario, numero_pedido) VALUES(14, 14, 1, 5.00, 17);
INSERT INTO db_soat.tb_composicao_pedido (id_composicao, id_produto, quantidade, preco_unitario, numero_pedido) VALUES(15, 15, 1, 10.00, 17);
INSERT INTO db_soat.tb_composicao_pedido (id_composicao, id_produto, quantidade, preco_unitario, numero_pedido) VALUES(16, 4, 1, 10.00, 17);
INSERT INTO db_soat.tb_composicao_pedido (id_composicao, id_produto, quantidade, preco_unitario, numero_pedido) VALUES(17, 23, 1, 8.00, 17);
INSERT INTO db_soat.tb_composicao_pedido (id_composicao, id_produto, quantidade, preco_unitario, numero_pedido) VALUES(18, 12, 1, 5.00, 18);
INSERT INTO db_soat.tb_composicao_pedido (id_composicao, id_produto, quantidade, preco_unitario, numero_pedido) VALUES(19, 15, 1, 10.00, 18);
INSERT INTO db_soat.tb_composicao_pedido (id_composicao, id_produto, quantidade, preco_unitario, numero_pedido) VALUES(20, 19, 1, 15.00, 18);
INSERT INTO db_soat.tb_composicao_pedido (id_composicao, id_produto, quantidade, preco_unitario, numero_pedido) VALUES(21, 21, 1, 7.00, 18);
INSERT INTO db_soat.tb_composicao_pedido (id_composicao, id_produto, quantidade, preco_unitario, numero_pedido) VALUES(22, 11, 1, 5.00, 19);
INSERT INTO db_soat.tb_composicao_pedido (id_composicao, id_produto, quantidade, preco_unitario, numero_pedido) VALUES(23, 18, 1, 15.00, 19);
INSERT INTO db_soat.tb_composicao_pedido (id_composicao, id_produto, quantidade, preco_unitario, numero_pedido) VALUES(24, 20, 1, 20.00, 20);
INSERT INTO db_soat.tb_composicao_pedido (id_composicao, id_produto, quantidade, preco_unitario, numero_pedido) VALUES(25, 14, 1, 5.00, 20);