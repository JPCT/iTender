--Insert into table bench--
INSERT INTO bench
(id, created_at, table_name)
VALUES('6903d089-e18d-40dc-bf3a-e0eb5216cba5', '2022-10-19 00:00:00.000', 'Mesa 1');
INSERT INTO bench
(id, created_at, table_name)
VALUES('b5752525-b9fb-4414-ba05-597639c7c96d', '2022-10-19 00:00:00.000', 'Mesa 2');
INSERT INTO bench
(id, created_at, table_name)
VALUES('6f62b846-9251-4e43-b8cb-ef83c61a800f', '2022-10-19 00:00:00.000', 'Mesa 3');
INSERT INTO bench
(id, created_at, table_name)
VALUES('85abe6f8-421e-4217-83db-bde578b1bbce', '2022-10-19 00:00:00.000', 'Mesa 4');
INSERT INTO bench
(id, created_at, table_name)
VALUES('72aee07c-925b-4f31-b001-aa6b616fc3c6', '2022-10-19 00:00:00.000', 'Mesa 5');
INSERT INTO bench
(id, created_at, table_name)
VALUES('193e3b0e-08e8-450b-aea2-4f5d647e8fd6', '2022-10-19 00:00:00.000', 'Mesa 6');
INSERT INTO bench
(id, created_at, table_name)
VALUES('df689732-e243-417e-9857-1bb264e96de5', '2022-10-19 00:00:00.000', 'Mesa 7');
INSERT INTO bench
(id, created_at, table_name)
VALUES('47ef8ad0-36fe-41ae-ab6b-98ed514476e3', '2022-10-19 00:00:00.000', 'Mesa 8');
INSERT INTO bench
(id, created_at, table_name)
VALUES('ba6b15c0-2ccd-4b61-9034-63ae1939ee58', '2022-10-19 00:00:00.000', 'Mesa 9');
INSERT INTO bench
(id, created_at, table_name)
VALUES('3f3aaa7e-66a0-4719-a4fb-6892e512e70d', '2022-10-19 00:00:00.000', 'Mesa 10');
INSERT INTO bench
(id, created_at, table_name)
VALUES('38325b6d-28ed-46f1-acef-e51f4befd421', '2022-10-19 00:00:00.000', 'Mesa 11');
INSERT INTO bench
(id, created_at, table_name)
VALUES('b4ad1050-5f2f-4ec2-aeef-50ca258cfeff', '2022-10-19 00:00:00.000', 'Mesa 12');
INSERT INTO bench
(id, created_at, table_name)
VALUES('6b998c88-8ee7-4fa4-84b0-615e96e8bf88', '2022-10-19 00:00:00.000', 'Mesa 13');


--Insert into table store--
INSERT INTO store
(id, created_at, description, logo_image_id, "name")
VALUES('297db8c6-9e70-4a50-803f-9a55ad4c483a', '2022-10-19 00:00:00.000', 'Se vende cafe, helado, tortas', '1ERlhXoqgNEJUMsFuvEV-LivNlqRxtoVs', 'Cafe Bambu');
INSERT INTO store
(id, created_at, description, logo_image_id, "name")
VALUES('d3c863c0-20be-4037-8d0c-fafd9091ff49', '2022-10-19 00:00:00.000', 'Se venden almuerzos y desayunos', '15kOqPHyd7h3uHEj5c2TTguc07tIjnIfe', 'Restaurante de Gloria');
INSERT INTO store
(id, created_at, description, logo_image_id, "name")
VALUES('003c18c1-1f67-4dd1-a053-9568075ff90a', '2022-10-19 00:00:00.000', 'Se vende comida rapida', '1Fzza_1EzJ2DwYrR-XheSaMwEFnWYrllo', 'Donde Lucas');
INSERT INTO store
(id, created_at, description, logo_image_id, "name")
VALUES('7b35ce7c-b72c-4107-88e0-4c31870afeea', '2022-10-19 00:00:00.000', 'Se venden licores', '1O_OwdRwNfxCghBbI4sIIXlS1U7VGh3hg', 'Estanquillo Tinoco');

--Insert into table item_category--
INSERT INTO item_category
(id, "name", store_id)
VALUES('1cddce2f-bbb4-4c38-a3cc-515c8dd27eed', 'Grano', 'd3c863c0-20be-4037-8d0c-fafd9091ff49');
INSERT INTO item_category
(id, "name", store_id)
VALUES('b151f9a6-bed0-4bb7-87dc-f33cfbc83c96', 'Verdura', 'd3c863c0-20be-4037-8d0c-fafd9091ff49');
INSERT INTO item_category
(id, "name", store_id)
VALUES('2ffdfaa1-f813-4ce1-8ef7-e1784a75471e', 'Fruta', 'd3c863c0-20be-4037-8d0c-fafd9091ff49');
INSERT INTO item_category
(id, "name", store_id)
VALUES('aa2d6dbd-2ad8-441d-b6a9-d2e8fd54cf0d', 'Tuberculo', 'd3c863c0-20be-4037-8d0c-fafd9091ff49');
INSERT INTO item_category
(id, "name", store_id)
VALUES('8ecb6f48-6f1b-4ffc-b074-1dfceb423577', 'Licor', '7b35ce7c-b72c-4107-88e0-4c31870afeea');
INSERT INTO item_category
(id, "name", store_id)
VALUES('072fbc1f-d6d7-449f-a1f3-47b6e8d11a50', 'Lacteo', '003c18c1-1f67-4dd1-a053-9568075ff90a');
INSERT INTO item_category
(id, "name", store_id)
VALUES('854497ab-c566-40b9-b8d6-0cef8c68194f', 'Proveniente de un animal', 'd3c863c0-20be-4037-8d0c-fafd9091ff49');
INSERT INTO item_category
(id, "name", store_id)
VALUES('c14da1c5-ebb3-49be-b7cd-0ff72c8598b7', 'Harina', 'd3c863c0-20be-4037-8d0c-fafd9091ff49');



--Insert into table product_category--
INSERT INTO product_category
(id, category_name, store_id)
VALUES('d27bc3e1-4c12-412d-aeaf-7b9311491465', 'Bebidas', '297db8c6-9e70-4a50-803f-9a55ad4c483a');
INSERT INTO product_category
(id, category_name, store_id)
VALUES('c5aa79f7-0e25-4c55-9353-2f09e016c488', 'Almuerzo', 'd3c863c0-20be-4037-8d0c-fafd9091ff49');
INSERT INTO product_category
(id, category_name, store_id)
VALUES('cb17f0b6-6701-4ae4-8561-453b876ddce4', 'Desayuno', 'd3c863c0-20be-4037-8d0c-fafd9091ff49');
INSERT INTO product_category
(id, category_name, store_id)
VALUES('f0b080e4-4787-4bb1-bab1-ea16cd5f2ac4', 'Licor', '7b35ce7c-b72c-4107-88e0-4c31870afeea');
INSERT INTO product_category
(id, category_name, store_id)
VALUES('f08f8488-6ad0-409d-a31e-aef5c2570c8f', 'Comida rapida', '003c18c1-1f67-4dd1-a053-9568075ff90a');

--Insert into table product--
INSERT INTO product
(id, description, image_id, "name", price, product_category_id, store_id)
VALUES('7b8fedca-585f-4e9f-8f51-367588294c3d', 'Bebida fuerte hecha a base de cafe', '1fbzrVI5jaX_nPWVljTjoAONhR0UvcDkp', 'Expreso', 2000, 'd27bc3e1-4c12-412d-aeaf-7b9311491465', '297db8c6-9e70-4a50-803f-9a55ad4c483a');
INSERT INTO product
(id, description, image_id, "name", price, product_category_id, store_id)
VALUES('41e02205-9b85-4159-aad9-c0771618ba44', 'Bebida suave hecha a base de cafe', '1fbzrVI5jaX_nPWVljTjoAONhR0UvcDkp', 'Americano', 2500, 'd27bc3e1-4c12-412d-aeaf-7b9311491465', '297db8c6-9e70-4a50-803f-9a55ad4c483a');
INSERT INTO product
(id, description, image_id, "name", price, product_category_id, store_id)
VALUES('7f4f0b6b-a746-47a9-9fa8-4a8edc4ef8d2', 'Arroz con frijoles, un huevo entero, una porcion de aguacate, tajadas de platano', '1fbzrVI5jaX_nPWVljTjoAONhR0UvcDkp', 'Bandeja paisa', 12000, 'c5aa79f7-0e25-4c55-9353-2f09e016c488', 'd3c863c0-20be-4037-8d0c-fafd9091ff49');
INSERT INTO product
(id, description, image_id, "name", price, product_category_id, store_id)
VALUES('19c298db-eb1c-452e-b9f3-c6903f84ddaf', 'Arepa con queso y chocolate', '1fbzrVI5jaX_nPWVljTjoAONhR0UvcDkp', 'Desayuno con arepa', 10000, 'cb17f0b6-6701-4ae4-8561-453b876ddce4', 'd3c863c0-20be-4037-8d0c-fafd9091ff49');
INSERT INTO product
(id, description, image_id, "name", price, product_category_id, store_id)
VALUES('e987fa78-a219-46de-8974-9691c9c78a83', 'Lentejas con arroz', '1fbzrVI5jaX_nPWVljTjoAONhR0UvcDkp', 'Lentejas con arroz', 11000, 'c5aa79f7-0e25-4c55-9353-2f09e016c488', 'd3c863c0-20be-4037-8d0c-fafd9091ff49');
INSERT INTO product
(id, description, image_id, "name", price, product_category_id, store_id)
VALUES('9df66b2f-f887-4422-a452-06d6073e08fe', 'Bebida a base de cafe con leche', '1fbzrVI5jaX_nPWVljTjoAONhR0UvcDkp', 'Mocaccino', 4000, 'd27bc3e1-4c12-412d-aeaf-7b9311491465', '297db8c6-9e70-4a50-803f-9a55ad4c483a');
INSERT INTO product
(id, description, image_id, "name", price, product_category_id, store_id)
VALUES('b8509e0c-e272-4310-9705-1b3ccc987b23', 'Helado con brownie', '1fbzrVI5jaX_nPWVljTjoAONhR0UvcDkp', 'Helado con brownie', 10000, 'f0b080e4-4787-4bb1-bab1-ea16cd5f2ac4', '003c18c1-1f67-4dd1-a053-9568075ff90a');
INSERT INTO product
(id, description, image_id, "name", price, product_category_id, store_id)
VALUES('5b31fbf8-f9af-4be4-bc62-87df28cf66c3', 'Botella de vino', '1fbzrVI5jaX_nPWVljTjoAONhR0UvcDkp', 'Botella de vino', 25000, 'f0b080e4-4787-4bb1-bab1-ea16cd5f2ac4', '7b35ce7c-b72c-4107-88e0-4c31870afeea');

--Insert into table item--
INSERT INTO item
(id, "name", price, stock, unit_measurement, item_category_id, product_id, store_id)
VALUES('0dca977a-fee3-4b0f-9b92-4ef6db639b61', 'Huevo', 250, 50, 2, '854497ab-c566-40b9-b8d6-0cef8c68194f', '7f4f0b6b-a746-47a9-9fa8-4a8edc4ef8d2', 'd3c863c0-20be-4037-8d0c-fafd9091ff49');
INSERT INTO item
(id, "name", price, stock, unit_measurement, item_category_id, product_id, store_id)
VALUES('0055b3d7-d784-4183-be4d-caf157c984b2', 'Arroz', 2390, 10, 0, '1cddce2f-bbb4-4c38-a3cc-515c8dd27eed', '7f4f0b6b-a746-47a9-9fa8-4a8edc4ef8d2', 'd3c863c0-20be-4037-8d0c-fafd9091ff49');
INSERT INTO item
(id, "name", price, stock, unit_measurement, item_category_id, product_id, store_id)
VALUES('827e2bd6-bb26-48ac-824a-4651ca0ce55f', 'Cafe', 23000, 20, 1, '1cddce2f-bbb4-4c38-a3cc-515c8dd27eed', '7b8fedca-585f-4e9f-8f51-367588294c3d', '297db8c6-9e70-4a50-803f-9a55ad4c483a');
INSERT INTO item
(id, "name", price, stock, unit_measurement, item_category_id, product_id, store_id)
VALUES('8c4bb4a9-ad47-44cc-99af-680efde322d3', 'Frijoles', 2000, 20, 0, '1cddce2f-bbb4-4c38-a3cc-515c8dd27eed', '7f4f0b6b-a746-47a9-9fa8-4a8edc4ef8d2', 'd3c863c0-20be-4037-8d0c-fafd9091ff49');
INSERT INTO item
(id, "name", price, stock, unit_measurement, item_category_id, product_id, store_id)
VALUES('26ed0a2a-e677-4d01-81c2-1fc03e0fd706', 'Lentejas', 1900, 25, 0, '1cddce2f-bbb4-4c38-a3cc-515c8dd27eed', 'e987fa78-a219-46de-8974-9691c9c78a83', 'd3c863c0-20be-4037-8d0c-fafd9091ff49');
INSERT INTO item
(id, "name", price, stock, unit_measurement, item_category_id, product_id, store_id)
VALUES('addaac7f-10ea-4243-973e-bd6d109f2bb8', 'Azucar', 2400, 25, 1, '1cddce2f-bbb4-4c38-a3cc-515c8dd27eed', '41e02205-9b85-4159-aad9-c0771618ba44', '297db8c6-9e70-4a50-803f-9a55ad4c483a');
INSERT INTO item
(id, "name", price, stock, unit_measurement, item_category_id, product_id, store_id)
VALUES('d4a65cc4-b339-445b-a623-3f186583138b', 'Sal', 2250, 23, 0, '1cddce2f-bbb4-4c38-a3cc-515c8dd27eed', '7f4f0b6b-a746-47a9-9fa8-4a8edc4ef8d2', 'd3c863c0-20be-4037-8d0c-fafd9091ff49');
INSERT INTO item
(id, "name", price, stock, unit_measurement, item_category_id, product_id, store_id)
VALUES('f54eb0c9-e819-4deb-8033-f2fd5ec86f1c', 'Arepa', 2000, 15, 2, 'c14da1c5-ebb3-49be-b7cd-0ff72c8598b7', '19c298db-eb1c-452e-b9f3-c6903f84ddaf', 'd3c863c0-20be-4037-8d0c-fafd9091ff49');
INSERT INTO item
(id, "name", price, stock, unit_measurement, item_category_id, product_id, store_id)
VALUES('f2934fac-d802-439a-9cd8-383645afbca1', 'Queso', 7000, 40, 2, '072fbc1f-d6d7-449f-a1f3-47b6e8d11a50', '19c298db-eb1c-452e-b9f3-c6903f84ddaf', 'd3c863c0-20be-4037-8d0c-fafd9091ff49');
INSERT INTO item
(id, "name", price, stock, unit_measurement, item_category_id, product_id, store_id)
VALUES('80183a58-1746-49b9-95e8-f9269000ff8a', 'Panela', 5000, 15, 2, '1cddce2f-bbb4-4c38-a3cc-515c8dd27eed', '19c298db-eb1c-452e-b9f3-c6903f84ddaf', 'd3c863c0-20be-4037-8d0c-fafd9091ff49');
INSERT INTO item
(id, "name", price, stock, unit_measurement, item_category_id, product_id, store_id)
VALUES('ee50bd1c-8d09-4351-9539-006647b3160a', 'Papa', 6000, 20, 1, 'aa2d6dbd-2ad8-441d-b6a9-d2e8fd54cf0d', 'e987fa78-a219-46de-8974-9691c9c78a83', 'd3c863c0-20be-4037-8d0c-fafd9091ff49');
INSERT INTO item
(id, "name", price, stock, unit_measurement, item_category_id, product_id, store_id)
VALUES('23ff09b6-87dc-48ef-890f-1f98bcb14e5f', 'Leche', 2500, 30, 2, '072fbc1f-d6d7-449f-a1f3-47b6e8d11a50', '9df66b2f-f887-4422-a452-06d6073e08fe', '297db8c6-9e70-4a50-803f-9a55ad4c483a');
INSERT INTO item
(id, "name", price, stock, unit_measurement, item_category_id, product_id, store_id)
VALUES('dc22cfd9-5571-44f1-b039-a9404f3f7ffe', 'Helado', 10000, 20, 1, '072fbc1f-d6d7-449f-a1f3-47b6e8d11a50', 'b8509e0c-e272-4310-9705-1b3ccc987b23', '003c18c1-1f67-4dd1-a053-9568075ff90a');
INSERT INTO item
(id, "name", price, stock, unit_measurement, item_category_id, product_id, store_id)
VALUES('9e9f6d81-4058-4cf5-ba04-6b32bd1671b0', 'Platano', 600, 30, 2, 'b151f9a6-bed0-4bb7-87dc-f33cfbc83c96', '7f4f0b6b-a746-47a9-9fa8-4a8edc4ef8d2', 'd3c863c0-20be-4037-8d0c-fafd9091ff49');
INSERT INTO item
(id, "name", price, stock, unit_measurement, item_category_id, product_id, store_id)
VALUES('9af7cc88-2aa0-48ec-970d-b221afe2f586', 'Aguacate', 2000, 35, 2, '2ffdfaa1-f813-4ce1-8ef7-e1784a75471e', '7f4f0b6b-a746-47a9-9fa8-4a8edc4ef8d2', 'd3c863c0-20be-4037-8d0c-fafd9091ff49');
INSERT INTO item
(id, "name", price, stock, unit_measurement, item_category_id, product_id, store_id)
VALUES('789ec13d-36f5-4110-b772-12e16dc35d2a', 'Vino', 25000, 20, 2, '8ecb6f48-6f1b-4ffc-b074-1dfceb423577', '5b31fbf8-f9af-4be4-bc62-87df28cf66c3', '7b35ce7c-b72c-4107-88e0-4c31870afeea');

--Insert into table role--
INSERT INTO "role"
(id, created_at, name, update_at)
VALUES('0353f568-6f13-4068-b40d-9845798fa0e4', '2022-10-20 21:10:28.355', 'ROLE_SUPER_ADMIN', '2022-10-20 21:10:28.355');
INSERT INTO "role"
(id, created_at, name, update_at)
VALUES('6e1b4703-ed4c-4cfd-ad72-2f7639131d68', '2022-10-20 21:10:28.584', 'ROLE_WAITER', '2022-10-20 21:10:28.584');
INSERT INTO "role"
(id, created_at, name, update_at)
VALUES('53c50b05-7770-4995-8fa8-5e732c181d25', '2022-10-22 21:10:28.584', 'ROLE_COMMERCE_ADMIN', '2022-10-22 21:10:28.584');
INSERT INTO "role"
(id, created_at, name, update_at)
VALUES('74b8c157-0775-4e0d-87a4-325d4c6a3523', '2022-10-22 21:10:28.584', 'ROLE_KITCHEN_STAFF', '2022-10-22 21:10:28.584');

--Insert into table user_app--
INSERT INTO user_app
(id, created_at, first_name, last_name, "password", phone_number, sex, update_at, username, store_id)
VALUES('d3f5f669-4409-4673-b404-5afc294c51fa', '2022-10-20 21:10:28.590', 'John', 'Mejia', '$2a$10$1XHzBVlygXeBYIkUeVaMDuExr555nsIgZG5HOpR3jM0P.7IZZFyIu', '3134554632', 0, '2022-10-20 21:10:28.590', 'john@email.com', NULL);
INSERT INTO user_app
(id, created_at, first_name, last_name, "password", phone_number, sex, update_at, username, store_id)
VALUES('c2aa163a-2fc2-4c82-aa02-d33d59fb30a5', '2022-10-19 23:41:14.350', 'Lucas', 'Bohorquez', '$2a$10$1XHzBVlygXeBYIkUeVaMDuExr555nsIgZG5HOpR3jM0P.7IZZFyIu', '3016120490', 0, '2022-10-20 23:41:14.350', 'lucas@email.com', NULL);
INSERT INTO user_app
(id, created_at, first_name, last_name, "password", phone_number, sex, update_at, username, store_id)
VALUES('4c6962ab-1844-4444-8443-6f87aaa32090', '2022-10-19 23:41:14.350', 'Pablo', 'Castaño', '$2a$10$1XHzBVlygXeBYIkUeVaMDuExr555nsIgZG5HOpR3jM0P.7IZZFyIu', '3136367416', 0, '2022-10-20 23:41:14.350', 'pablo@email.com', NULL);
INSERT INTO user_app
(id, created_at, first_name, last_name, "password", phone_number, sex, update_at, username, store_id)
VALUES('bc02a37d-bbe8-4d2c-924b-8c1f569b182e', '2022-10-22 23:41:14.350', 'Daniel', 'Alejandro', '$2a$10$1XHzBVlygXeBYIkUeVaMDuExr555nsIgZG5HOpR3jM0P.7IZZFyIu', '3214216598', 0, '2022-10-22 23:41:14.350', 'daniel@gmail.com', NULL);
INSERT INTO user_app
(id, created_at, first_name, last_name, "password", phone_number, sex, update_at, username, store_id)
VALUES('eecbee25-49bf-4b8e-9e0c-5ab3d2c7ea39', '2022-10-23 23:41:14.350', 'Daniela', 'Lopez', '$2a$10$1XHzBVlygXeBYIkUeVaMDuExr555nsIgZG5HOpR3jM0P.7IZZFyIu', '3118558254', 1, '2022-10-23 23:41:14.350', 'daniela@gmail.com', NULL);

--Insert into table user_app_roles--
INSERT INTO user_app_roles
(user_app_id, roles_id)
SELECT 'd3f5f669-4409-4673-b404-5afc294c51fa', '0353f568-6f13-4068-b40d-9845798fa0e4'
WHERE NOT EXISTS (SELECT user_app_id, roles_id FROM user_app_roles WHERE user_app_id = 'd3f5f669-4409-4673-b404-5afc294c51fa' AND roles_id = '0353f568-6f13-4068-b40d-9845798fa0e4');
INSERT INTO user_app_roles
(user_app_id, roles_id)
SELECT 'd3f5f669-4409-4673-b404-5afc294c51fa', '6e1b4703-ed4c-4cfd-ad72-2f7639131d68'
WHERE NOT EXISTS (SELECT user_app_id, roles_id FROM user_app_roles WHERE user_app_id = 'd3f5f669-4409-4673-b404-5afc294c51fa' AND roles_id = '6e1b4703-ed4c-4cfd-ad72-2f7639131d68');
INSERT INTO user_app_roles
(user_app_id, roles_id)
SELECT 'd3f5f669-4409-4673-b404-5afc294c51fa', '74b8c157-0775-4e0d-87a4-325d4c6a3523'
WHERE NOT EXISTS (SELECT user_app_id, roles_id FROM user_app_roles WHERE user_app_id = 'd3f5f669-4409-4673-b404-5afc294c51fa' AND roles_id = '74b8c157-0775-4e0d-87a4-325d4c6a3523');
INSERT INTO user_app_roles
(user_app_id, roles_id)
SELECT 'd3f5f669-4409-4673-b404-5afc294c51fa', '53c50b05-7770-4995-8fa8-5e732c181d25'
WHERE NOT EXISTS (SELECT user_app_id, roles_id FROM user_app_roles WHERE user_app_id = 'd3f5f669-4409-4673-b404-5afc294c51fa' AND roles_id = '53c50b05-7770-4995-8fa8-5e732c181d25');
INSERT INTO user_app_roles
(user_app_id, roles_id)
SELECT 'c2aa163a-2fc2-4c82-aa02-d33d59fb30a5', '6e1b4703-ed4c-4cfd-ad72-2f7639131d68'
WHERE NOT EXISTS (SELECT user_app_id, roles_id FROM user_app_roles WHERE user_app_id = 'c2aa163a-2fc2-4c82-aa02-d33d59fb30a5' AND roles_id = '6e1b4703-ed4c-4cfd-ad72-2f7639131d68');
INSERT INTO user_app_roles
(user_app_id, roles_id)
SELECT '4c6962ab-1844-4444-8443-6f87aaa32090', '6e1b4703-ed4c-4cfd-ad72-2f7639131d68'
WHERE NOT EXISTS (SELECT user_app_id, roles_id FROM user_app_roles WHERE user_app_id = '4c6962ab-1844-4444-8443-6f87aaa32090' AND roles_id = '6e1b4703-ed4c-4cfd-ad72-2f7639131d68');
INSERT INTO user_app_roles
(user_app_id, roles_id)
SELECT 'bc02a37d-bbe8-4d2c-924b-8c1f569b182e', '74b8c157-0775-4e0d-87a4-325d4c6a3523'
WHERE NOT EXISTS (SELECT user_app_id, roles_id FROM user_app_roles WHERE user_app_id = 'bc02a37d-bbe8-4d2c-924b-8c1f569b182e' AND roles_id = '74b8c157-0775-4e0d-87a4-325d4c6a3523');
INSERT INTO user_app_roles
(user_app_id, roles_id)
SELECT 'eecbee25-49bf-4b8e-9e0c-5ab3d2c7ea39', '53c50b05-7770-4995-8fa8-5e732c181d25'
WHERE NOT EXISTS (SELECT user_app_id, roles_id FROM user_app_roles WHERE user_app_id = 'eecbee25-49bf-4b8e-9e0c-5ab3d2c7ea39' AND roles_id = '53c50b05-7770-4995-8fa8-5e732c181d25');


--Insert into table order_app--
INSERT INTO order_app
(id, client_name, confirm_date, cooking_date, deliver_date, order_date, pay_date, price, status, table_app_id, user_app_id)
VALUES('340548c4-feb8-432b-a9d4-62c6eed2afe3', 'Daniel', '2022-10-20 10:45:00.000', '2022-10-20 11:00:00.000', '2022-10-20 11:20:00.000', '2022-10-20 10:40:00.000', '2022-10-20 12:00:00.000', 58500, 6, '6903d089-e18d-40dc-bf3a-e0eb5216cba5', 'c2aa163a-2fc2-4c82-aa02-d33d59fb30a5');
INSERT INTO order_app
(id, client_name, confirm_date, cooking_date, deliver_date, order_date, pay_date, price, status, table_app_id, user_app_id)
VALUES('77d37fd8-9cff-40f9-89f9-dc3bfee284ce', 'Gabriela', '2022-10-21 10:45:00.000', '2022-10-21 11:00:00.000', '2022-10-21 11:20:00.000', '2022-10-21 10:40:00.000', '2022-10-21 12:00:00.000', 90400, 6, '72aee07c-925b-4f31-b001-aa6b616fc3c6', '4c6962ab-1844-4444-8443-6f87aaa32090');
INSERT INTO order_app
(id, client_name, confirm_date, cooking_date, deliver_date, order_date, pay_date, price, status, table_app_id, user_app_id)
VALUES('c733a833-5f83-47c8-92b8-d016b448bb01', 'Daniela', '2022-10-22 10:45:00.000', NULL, NULL, '2022-10-22 10:40:00.000', NULL, 40500, 2, '38325b6d-28ed-46f1-acef-e51f4befd421', 'c2aa163a-2fc2-4c82-aa02-d33d59fb30a5');
INSERT INTO order_app
(id, client_name, confirm_date, cooking_date, deliver_date, order_date, pay_date, price, status, table_app_id, user_app_id)
VALUES('b246b4d4-125e-4d57-97ed-3193f0bae64c', 'Caicedo', '2022-10-22 15:45:00.000', '2022-10-22 16:00:00.000', NULL, '2022-10-22 15:40:00.000', NULL, 67900, 3, '85abe6f8-421e-4217-83db-bde578b1bbce', 'c2aa163a-2fc2-4c82-aa02-d33d59fb30a5');
INSERT INTO order_app
(id, client_name, confirm_date, cooking_date, deliver_date, order_date, pay_date, price, status, table_app_id, user_app_id)
VALUES('1a66351e-93d2-4165-be62-5d06d9c1995f', 'Beatriz', '2022-10-23 17:45:00.000', '2022-10-23 18:00:00.000', '2022-10-23 18:20:00.000', '2022-10-23 17:40:00.000', NULL, 65700, 5, '47ef8ad0-36fe-41ae-ab6b-98ed514476e3', '4c6962ab-1844-4444-8443-6f87aaa32090');
INSERT INTO order_app
(id, client_name, confirm_date, cooking_date, deliver_date, order_date, pay_date, price, status, table_app_id, user_app_id)
VALUES('1ebfa638-ef78-40e1-8ea5-6720cf1529f7', 'Sebastian', '2022-10-24 13:45:00.000', '2022-10-24 14:00:00.000', NULL, '2022-10-24 13:40:00.000', NULL, 84600, 4, 'df689732-e243-417e-9857-1bb264e96de5', 'c2aa163a-2fc2-4c82-aa02-d33d59fb30a5');

