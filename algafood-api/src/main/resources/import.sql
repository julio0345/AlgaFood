insert into kitchen (id, name) values(1, 'Japonesa'), (2, 'Tailandesa'), (3, 'Mexicana');

insert into restaurant (name, price_delivery, kitchen_id) values('Skema', 15.0, 1), ('Cheio de Graça',19.30, 2), ('Milhão', 37.77, 3);

insert into state (description) values ('Minas Gerais'), ('Rio de Janeiro'), ('São Paulo'), ('Acre');

insert into city (name, id_state) values ('Divinópolis', 1), ('Copa Cabana',2), ('Olimpia',3), ('Rio Branco', 4);

insert into payment_form (description) values ('Cartão de Crédito'), ('Dinheiro'), ('Cheque'), ('Vale-Refeição');

insert into restaurant_payment_form (restaurant_id, payment_form_id) values(1,1), (1,2), (1,3), (2,1), (3,2);

insert into permission(name, description) values('Administrador', 'Acesso geral ao sistema'), ('Vendas','Somente modulo de vendas');

insert into group (name) values ('usuarios internos'), ('usuarios externos');