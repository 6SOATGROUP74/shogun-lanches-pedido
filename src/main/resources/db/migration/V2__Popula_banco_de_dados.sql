
-- Insere pedidos
INSERT INTO db_soat_pedido.tb_pedido (numero_pedido, data_pedido, valor_total, etapa, id_cliente, id_pagamento, data_mudanca_etapa) VALUES(15, '2024-05-28 00:15:01', 53.00, 'RECEBIDO', '3b614bf6-9fa7-4cbe-9ef9-9b678840b953', NULL, NULL);
INSERT INTO db_soat_pedido.tb_pedido (numero_pedido, data_pedido, valor_total, etapa, id_cliente, id_pagamento, data_mudanca_etapa) VALUES(16, '2024-05-28 00:17:39', 34.00, 'RECEBIDO', '3b614bf6-9fa7-4cbe-9ef9-9b678840b953', NULL, NULL);
INSERT INTO db_soat_pedido.tb_pedido (numero_pedido, data_pedido, valor_total, etapa, id_cliente, id_pagamento, data_mudanca_etapa) VALUES(17, '2024-05-28 00:19:27', 33.00, 'RECEBIDO', '3b614bf6-9fa7-4cbe-9ef9-9b678840b953', NULL, NULL);
INSERT INTO db_soat_pedido.tb_pedido (numero_pedido, data_pedido, valor_total, etapa, id_cliente, id_pagamento, data_mudanca_etapa) VALUES(18, '2024-05-28 00:20:42', 37.00, 'RECEBIDO', '3b614bf6-9fa7-4cbe-9ef9-9b678840b953', NULL, NULL);
INSERT INTO db_soat_pedido.tb_pedido (numero_pedido, data_pedido, valor_total, etapa, id_cliente, id_pagamento, data_mudanca_etapa) VALUES(19, '2024-05-28 00:21:13', 20.00, 'RECEBIDO', '3b614bf6-9fa7-4cbe-9ef9-9b678840b953', NULL, NULL);
INSERT INTO db_soat_pedido.tb_pedido (numero_pedido, data_pedido, valor_total, etapa, id_cliente, id_pagamento, data_mudanca_etapa) VALUES(20, '2024-05-28 00:39:58', 25.00, 'RECEBIDO', '3b614bf6-9fa7-4cbe-9ef9-9b678840b953', NULL, NULL);

-- Insere composicao
INSERT INTO db_soat_pedido.tb_composicao_pedido (id_composicao, id_produto, quantidade, preco_unitario, numero_pedido) VALUES(5, 1, 1, 5.00, 15);
INSERT INTO db_soat_pedido.tb_composicao_pedido (id_composicao, id_produto, quantidade, preco_unitario, numero_pedido) VALUES(6, 5, 1, 6.00, 15);
INSERT INTO db_soat_pedido.tb_composicao_pedido (id_composicao, id_produto, quantidade, preco_unitario, numero_pedido) VALUES(7, 20, 1, 20.00, 15);
INSERT INTO db_soat_pedido.tb_composicao_pedido (id_composicao, id_produto, quantidade, preco_unitario, numero_pedido) VALUES(8, 15, 1, 10.00, 15);
INSERT INTO db_soat_pedido.tb_composicao_pedido (id_composicao, id_produto, quantidade, preco_unitario, numero_pedido) VALUES(9, 16, 1, 12.00, 15);
INSERT INTO db_soat_pedido.tb_composicao_pedido (id_composicao, id_produto, quantidade, preco_unitario, numero_pedido) VALUES(10, 2, 1, 5.00, 16);
INSERT INTO db_soat_pedido.tb_composicao_pedido (id_composicao, id_produto, quantidade, preco_unitario, numero_pedido) VALUES(11, 15, 1, 10.00, 16);
INSERT INTO db_soat_pedido.tb_composicao_pedido (id_composicao, id_produto, quantidade, preco_unitario, numero_pedido) VALUES(12, 17, 1, 12.00, 16);
INSERT INTO db_soat_pedido.tb_composicao_pedido (id_composicao, id_produto, quantidade, preco_unitario, numero_pedido) VALUES(13, 22, 1, 7.00, 16);
INSERT INTO db_soat_pedido.tb_composicao_pedido (id_composicao, id_produto, quantidade, preco_unitario, numero_pedido) VALUES(14, 14, 1, 5.00, 17);
INSERT INTO db_soat_pedido.tb_composicao_pedido (id_composicao, id_produto, quantidade, preco_unitario, numero_pedido) VALUES(15, 15, 1, 10.00, 17);
INSERT INTO db_soat_pedido.tb_composicao_pedido (id_composicao, id_produto, quantidade, preco_unitario, numero_pedido) VALUES(16, 4, 1, 10.00, 17);
INSERT INTO db_soat_pedido.tb_composicao_pedido (id_composicao, id_produto, quantidade, preco_unitario, numero_pedido) VALUES(17, 23, 1, 8.00, 17);
INSERT INTO db_soat_pedido.tb_composicao_pedido (id_composicao, id_produto, quantidade, preco_unitario, numero_pedido) VALUES(18, 12, 1, 5.00, 18);
INSERT INTO db_soat_pedido.tb_composicao_pedido (id_composicao, id_produto, quantidade, preco_unitario, numero_pedido) VALUES(19, 15, 1, 10.00, 18);
INSERT INTO db_soat_pedido.tb_composicao_pedido (id_composicao, id_produto, quantidade, preco_unitario, numero_pedido) VALUES(20, 19, 1, 15.00, 18);
INSERT INTO db_soat_pedido.tb_composicao_pedido (id_composicao, id_produto, quantidade, preco_unitario, numero_pedido) VALUES(21, 21, 1, 7.00, 18);
INSERT INTO db_soat_pedido.tb_composicao_pedido (id_composicao, id_produto, quantidade, preco_unitario, numero_pedido) VALUES(22, 11, 1, 5.00, 19);
INSERT INTO db_soat_pedido.tb_composicao_pedido (id_composicao, id_produto, quantidade, preco_unitario, numero_pedido) VALUES(23, 18, 1, 15.00, 19);
INSERT INTO db_soat_pedido.tb_composicao_pedido (id_composicao, id_produto, quantidade, preco_unitario, numero_pedido) VALUES(24, 20, 1, 20.00, 20);
INSERT INTO db_soat_pedido.tb_composicao_pedido (id_composicao, id_produto, quantidade, preco_unitario, numero_pedido) VALUES(25, 14, 1, 5.00, 20);