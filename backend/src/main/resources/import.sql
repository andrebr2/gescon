INSERT INTO tb_servico(servico) VALUES('produção software');
INSERT INTO tb_servico(servico) VALUES('instalação datacenter');
INSERT INTO tb_servico(servico) VALUES('instalação elétrica');
INSERT INTO tb_servico(servico) VALUES('instalação hidráulica');
INSERT INTO tb_servico(servico) VALUES('construção concreto armado');
INSERT INTO tb_servico(servico) VALUES('construção pré-moldado');
INSERT INTO tb_servico(servico) VALUES('limpeza industrial');
INSERT INTO tb_servico(servico) VALUES('auditoria externa');

INSERT INTO tb_empresa(empresa, responsavel) VALUES('Armazém Tech', 'Mario Dantas');
INSERT INTO tb_empresa(empresa, responsavel) VALUES('Tech Soluções', 'Tassine Rosa');
INSERT INTO tb_empresa(empresa, responsavel) VALUES('Voltz Engenharia', 'Carla Prattes');
INSERT INTO tb_empresa(empresa, responsavel) VALUES('Hydra Ltda', 'José Sodré');
INSERT INTO tb_empresa(empresa, responsavel) VALUES('Construtora Magalhães Pires', 'Adão Ribas');
INSERT INTO tb_empresa(empresa, responsavel) VALUES('ABS Empreendimentos', 'Patricia Soares');
INSERT INTO tb_empresa(empresa, responsavel) VALUES('Geral Clean', 'Romão Cazares');
INSERT INTO tb_empresa(empresa, responsavel) VALUES('Brandi Assessoria Empresarial', 'Joana Vailões');

INSERT INTO tb_contrato(objeto_contrato, data_inicio, data_fim, latitude, longitude, servico_id, empresa_id) VALUES('Desenvolvimento software vendas Atacado Gusmão', '2024-10-30', '2025-01-30', -25.2413156, -53.9910585, 2, 2);
INSERT INTO tb_contrato(objeto_contrato, data_inicio, data_fim, latitude, longitude, servico_id, empresa_id) VALUES('Instalação do datacenter da Universidade Oeste', '2024-09-05', '2025-02-05', -24.9637481, -53.5535622, 1, 1);
INSERT INTO tb_contrato(objeto_contrato, data_inicio, data_fim, latitude, longitude, servico_id, empresa_id) VALUES('Instalação do sistema elétrico da Cooperativa Três Fronteiras', '2024-10-15', '2024-11-11', -25.2909625, -54.1177115, 3, 3);
INSERT INTO tb_contrato(objeto_contrato, data_inicio, data_fim, latitude, longitude, servico_id, empresa_id) VALUES('Instalação do sistema de captação de água da Fazenda Esperança', '2024-11-10', '2024-12-10', -25.345071, -54.2489165, 4, 4);
INSERT INTO tb_contrato(objeto_contrato, data_inicio, data_fim, latitude, longitude, servico_id, empresa_id) VALUES('Construção do Centro Cultural Alvorada', '2024-06-15', '2025-12-15', -25.0877514, -54.2666365, 5, 5);
INSERT INTO tb_contrato(objeto_contrato, data_inicio, data_fim, latitude, longitude, servico_id, empresa_id) VALUES('Construção do barracão da indústria de paletes PLZ', '2024-07-05', '2024-10-05', -25.5185093, -54.6291026, 6, 6);
INSERT INTO tb_contrato(objeto_contrato, data_inicio, data_fim, latitude, longitude, servico_id, empresa_id) VALUES('Limpeza da unidade industrial de aves Piquerez', '2024-11-09', '2024-11-10', -24.6681067, -53.9083391, 7, 7);
INSERT INTO tb_contrato(objeto_contrato, data_inicio, data_fim, latitude, longitude, servico_id, empresa_id) VALUES('Serviço de auditoria da Cerealista Jatobá', '2024-11-30', '2024-12-15', -25.0511189, -53.6355864, 8, 8);
INSERT INTO tb_contrato(objeto_contrato, data_inicio, data_fim, latitude, longitude, servico_id, empresa_id) VALUES('Construção da pista de skate park na praça Rocha Filho', '2025-01-15', '2025-04-30', -24.5501742, -54.1027667, 5, 5);
INSERT INTO tb_contrato(objeto_contrato, data_inicio, data_fim, latitude, longitude, servico_id, empresa_id) VALUES('Desenvolvimento do site de ecommerce do magazine POP', '2024-07-05', '2024-10-30', -26.1977685, -52.767256, 2, 2);