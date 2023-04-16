DELETE FROM customer;
INSERT INTO customer(ID, CREATIONTIME, UPDATETIME, VERSION, FIRSTNAME, LASTNAME, EMAIL, PHONE, PASSWORD, BALANCE) VALUES
  (1, TIMESTAMP '2017-10-10 08:45:56.468', TIMESTAMP '2017-10-10 08:45:56.468', 0, 'Rui', 'Ferrão', 'mail1@gmail.com', '77788812', '123', '100'),
  (2, TIMESTAMP '2017-10-10 08:45:56.481', TIMESTAMP '2017-10-10 08:45:56.481', 0, 'Sergio', 'Gouveia', 'mail2@gmail.com', '7773888', '123', '100'),
  (3, TIMESTAMP '2017-10-10 08:45:56.482', TIMESTAMP '2017-10-10 08:45:56.482', 0, 'Bruno', 'Ferreira', 'mai3l@gmail.com', '7778488', '123', '100'),
  (4, TIMESTAMP '2017-10-10 08:45:56.482', TIMESTAMP '2017-10-10 08:45:56.482', 0, 'No Accounts', 'No name', 'mail4@gmail.com', '7778858', '123', '100');


DELETE FROM products;
INSERT INTO products(SUBTYPE, ID, DESCRIPTION, PRICE) VALUES
  ('MAX',1, 'a melhor merda', '100'),
  ('LIGHT', 2 , 'a merda mais ou menos', '50'),
  ('MEDIUM', 3 , 'a pior merda', '25');

