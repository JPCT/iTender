--Insert into table bench--
INSERT INTO bench
(id, created_at, table_name)
VALUES(1, '2022-10-19 00:00:00.000', 'Mesa 1');
INSERT INTO bench
(id, created_at, table_name)
VALUES(2, '2022-10-19 00:00:00.000', 'Mesa 2');
INSERT INTO bench
(id, created_at, table_name)
VALUES(3, '2022-10-19 00:00:00.000', 'Mesa 3');
INSERT INTO bench
(id, created_at, table_name)
VALUES(4, '2022-10-19 00:00:00.000', 'Mesa 4');
INSERT INTO bench
(id, created_at, table_name)
VALUES(5, '2022-10-19 00:00:00.000', 'Mesa 5');
INSERT INTO bench
(id, created_at, table_name)
VALUES(6, '2022-10-19 00:00:00.000', 'Mesa 6');
INSERT INTO bench
(id, created_at, table_name)
VALUES(7, '2022-10-19 00:00:00.000', 'Mesa 7');
INSERT INTO bench
(id, created_at, table_name)
VALUES(8, '2022-10-19 00:00:00.000', 'Mesa 8');
INSERT INTO bench
(id, created_at, table_name)
VALUES(9, '2022-10-19 00:00:00.000', 'Mesa 9');
INSERT INTO bench
(id, created_at, table_name)
VALUES(10, '2022-10-19 00:00:00.000', 'Mesa 10');
INSERT INTO bench
(id, created_at, table_name)
VALUES(11, '2022-10-19 00:00:00.000', 'Mesa 11');
INSERT INTO bench
(id, created_at, table_name)
VALUES(12, '2022-10-19 00:00:00.000', 'Mesa 12');
INSERT INTO bench
(id, created_at, table_name)
VALUES(13, '2022-10-19 00:00:00.000', 'Mesa 13');


--Insert into table store--
INSERT INTO store
(id, created_at, description, logo_url, "name")
VALUES(1, '2022-10-19 00:00:00.000', 'Se vende cafe, helado, tortas', NULL, 'Cafe Bambu');
INSERT INTO store
(id, created_at, description, logo_url, "name")
VALUES(2, '2022-10-19 00:00:00.000', 'Se venden almuerzos y desayunos', NULL, 'Restaurante de Gloria');
INSERT INTO store
(id, created_at, description, logo_url, "name")
VALUES(3, '2022-10-19 00:00:00.000', 'Se vende comida rapida', NULL, 'Donde Lucas');
INSERT INTO store
(id, created_at, description, logo_url, "name")
VALUES(4, '2022-10-19 00:00:00.000', 'Se venden licores', NULL, 'Estanquillo Tinoco');

--Insert into table item_category--
INSERT INTO item_category
(id, "name", store_id)
VALUES(1, 'Grano', 2);
INSERT INTO item_category
(id, "name", store_id)
VALUES(2, 'Verdura', 2);
INSERT INTO item_category
(id, "name", store_id)
VALUES(3, 'Fruta', 2);
INSERT INTO item_category
(id, "name", store_id)
VALUES(4, 'Tuberculo', 2);
INSERT INTO item_category
(id, "name", store_id)
VALUES(5, 'Licor', 4);
INSERT INTO item_category
(id, "name", store_id)
VALUES(6, 'Lacteo', 3);
INSERT INTO item_category
(id, "name", store_id)
VALUES(7, 'Proveniente de un animal', 2);
INSERT INTO item_category
(id, "name", store_id)
VALUES(8, 'Harina', 2);



--Insert into table product_category--
INSERT INTO product_category
(id, category_name, store_id)
VALUES(1, 'Bebidas', 1);
INSERT INTO product_category
(id, category_name, store_id)
VALUES(2, 'Almuerzo', 2);
INSERT INTO product_category
(id, category_name, store_id)
VALUES(3, 'Desayuno', 2);
INSERT INTO product_category
(id, category_name, store_id)
VALUES(4, 'Licor', 4);
INSERT INTO product_category
(id, category_name, store_id)
VALUES(5, 'Comida rapida', 3);

--Insert into table product--
INSERT INTO product
(id, description, image_url, "name", price, product_category_id, store_id)
VALUES(1, 'Bebida fuerte hecha a base de cafe', NULL, 'Expreso', 2000, 1, 1);
INSERT INTO product
(id, description, image_url, "name", price, product_category_id, store_id)
VALUES(2, 'Bebida suave hecha a base de cafe', NULL, 'Americano', 2500, 1, 1);
INSERT INTO product
(id, description, image_url, "name", price, product_category_id, store_id)
VALUES(3, 'Arroz con frijoles, un huevo entero, una porcion de aguacate, tajadas de platano', NULL, 'Bandeja paisa', 12000, 2, 2);
INSERT INTO product
(id, description, image_url, "name", price, product_category_id, store_id)
VALUES(4, 'Arepa con queso y chocolate', NULL, 'Desayuno con arepa', 10000, 3, 2);
INSERT INTO product
(id, description, image_url, "name", price, product_category_id, store_id)
VALUES(5, 'Lentejas con arroz', NULL, 'Lentejas con arroz', 11000, 2, 2);
INSERT INTO product
(id, description, image_url, "name", price, product_category_id, store_id)
VALUES(6, 'Bebida a base de cafe con leche', NULL, 'Mocaccino', 4000, 1, 1);
INSERT INTO product
(id, description, image_url, "name", price, product_category_id, store_id)
VALUES(7, 'Helado con brownie', NULL, 'Helado con brownie', 10000, 5, 3);
INSERT INTO product
(id, description, image_url, "name", price, product_category_id, store_id)
VALUES(8, 'Botella de vino', NULL, 'Botella de vino', 25000, 4, 4);

--Insert into table item--
INSERT INTO item
(id, "name", price, stock, unit_measurement, item_category_id, product_id, store_id)
VALUES(1, 'Huevo', 250, 50, 2, 7, 3, 2);
INSERT INTO item
(id, "name", price, stock, unit_measurement, item_category_id, product_id, store_id)
VALUES(2, 'Arroz', 2390, 10, 0, 1, 3, 2);
INSERT INTO item
(id, "name", price, stock, unit_measurement, item_category_id, product_id, store_id)
VALUES(3, 'Cafe', 23000, 20, 1, 1, 1, 1);
INSERT INTO item
(id, "name", price, stock, unit_measurement, item_category_id, product_id, store_id)
VALUES(4, 'Frijoles', 2000, 20, 0, 1, 3, 2);
INSERT INTO item
(id, "name", price, stock, unit_measurement, item_category_id, product_id, store_id)
VALUES(5, 'Lentejas', 1900, 25, 0, 1, 5, 2);
INSERT INTO item
(id, "name", price, stock, unit_measurement, item_category_id, product_id, store_id)
VALUES(6, 'Azucar', 2400, 25, 1, 1, 2, 1);
INSERT INTO item
(id, "name", price, stock, unit_measurement, item_category_id, product_id, store_id)
VALUES(7, 'Sal', 2250, 23, 0, 1, 3, 2);
INSERT INTO item
(id, "name", price, stock, unit_measurement, item_category_id, product_id, store_id)
VALUES(8, 'Arepa', 2000, 15, 2, 8, 4, 2);
INSERT INTO item
(id, "name", price, stock, unit_measurement, item_category_id, product_id, store_id)
VALUES(9, 'Queso', 7000, 40, 2, 6, 4, 2);
INSERT INTO item
(id, "name", price, stock, unit_measurement, item_category_id, product_id, store_id)
VALUES(10, 'Panela', 5000, 15, 2, 1, 4, 2);
INSERT INTO item
(id, "name", price, stock, unit_measurement, item_category_id, product_id, store_id)
VALUES(11, 'Papa', 6000, 20, 1, 4, 5, 2);
INSERT INTO item
(id, "name", price, stock, unit_measurement, item_category_id, product_id, store_id)
VALUES(12, 'Leche', 2500, 30, 2, 6, 6, 1);
INSERT INTO item
(id, "name", price, stock, unit_measurement, item_category_id, product_id, store_id)
VALUES(13, 'Helado', 10000, 20, 1, 6, 7, 3);
INSERT INTO item
(id, "name", price, stock, unit_measurement, item_category_id, product_id, store_id)
VALUES(14, 'Platano', 600, 30, 2, 2, 3, 2);
INSERT INTO item
(id, "name", price, stock, unit_measurement, item_category_id, product_id, store_id)
VALUES(15, 'Aguacate', 2000, 35, 2, 3, 3, 2);
INSERT INTO item
(id, "name", price, stock, unit_measurement, item_category_id, product_id, store_id)
VALUES(16, 'Vino', 25000, 20, 2, 5, 8, 4);

--Insert into table user_app--
INSERT INTO user_app
(id, created_at, first_name, last_name, "password", phone_number, sex, update_at, username, store_id)
VALUES(2, '2022-10-19 23:41:14.350', 'Lucas', 'Bohorquez', '$2a$10$uUESbtRXmOsD4x.atWkwtOKBYZlxWH2KMpgC3D8xYbmF25NfCP3pm', '3016120490', 0, '2022-10-20 23:41:14.350', 'lucas@email.com', NULL);
INSERT INTO user_app
(id, created_at, first_name, last_name, "password", phone_number, sex, update_at, username, store_id)
VALUES(1, '2022-10-19 23:41:14.350', 'Pablo', 'Castaño', '$2a$10$uUESbtRXmOsD4x.atWkwtOKBYZlxWH2KMpgC3D8xYbmF25NfCP3lm', '3136367416', 0, '2022-10-20 23:41:14.350', 'pablo@email.com', NULL);

--Insert into table user_app_roles--
INSERT INTO user_app_roles
(user_app_id, roles_id)
VALUES(2, 2);
INSERT INTO user_app_roles
(user_app_id, roles_id)
VALUES(1, 2);

--Insert into table order_app--
INSERT INTO order_app
(id, client_name, confirm_date, cooking_date, deliver_date, order_date, pay_date, price, status, table_app_id, user_app_id)
VALUES(1, 'Daniel', '2022-10-20 10:45:00.000', '2022-10-20 11:00:00.000', '2022-10-20 11:20:00.000', '2022-10-20 10:40:00.000', '2022-10-20 12:00:00.000', 58500, 6, 1, 2);
INSERT INTO order_app
(id, client_name, confirm_date, cooking_date, deliver_date, order_date, pay_date, price, status, table_app_id, user_app_id)
VALUES(2, 'Gabriela', '2022-10-21 10:45:00.000', '2022-10-21 11:00:00.000', '2022-10-21 11:20:00.000', '2022-10-21 10:40:00.000', '2022-10-21 12:00:00.000', 90400, 6, 5, 1);
INSERT INTO order_app
(id, client_name, confirm_date, cooking_date, deliver_date, order_date, pay_date, price, status, table_app_id, user_app_id)
VALUES(3, 'Daniela', '2022-10-22 10:45:00.000', NULL, NULL, '2022-10-22 10:40:00.000', NULL, 40500, 2, 11, 2);
INSERT INTO order_app
(id, client_name, confirm_date, cooking_date, deliver_date, order_date, pay_date, price, status, table_app_id, user_app_id)
VALUES(4, 'Caicedo', '2022-10-22 15:45:00.000', '2022-10-22 16:00:00.000', NULL, '2022-10-22 15:40:00.000', NULL, 67900, 3, 4, 2);
INSERT INTO order_app
(id, client_name, confirm_date, cooking_date, deliver_date, order_date, pay_date, price, status, table_app_id, user_app_id)
VALUES(5, 'Beatriz', '2022-10-23 17:45:00.000', '2022-10-23 18:00:00.000', '2022-10-23 18:20:00.000', '2022-10-23 17:40:00.000', NULL, 65700, 5, 8, 1);
INSERT INTO order_app
(id, client_name, confirm_date, cooking_date, deliver_date, order_date, pay_date, price, status, table_app_id, user_app_id)
VALUES(6, 'Sebastian', '2022-10-24 13:45:00.000', '2022-10-24 14:00:00.000', NULL, '2022-10-24 13:40:00.000', NULL, 84600, 4, 7, 2);

