
DROP TABLE IF EXISTS product CASCADE;
DROP TABLE IF EXISTS product_category CASCADE;
DROP TABLE IF EXISTS supplier CASCADE;



CREATE TABLE Product(
  id SERIAL,
  name VARCHAR(255),
  default_price FLOAT,
  currency_string VARCHAR (7),
  description VARCHAR (255),
  product_category_id INT,
  supplier_id INT,
  PRIMARY KEY (id)
);

CREATE TABLE Product_Category(
  id SERIAL,
  name VARCHAR(255),
  department VARCHAR (255),
  description VARCHAR (255),
  PRIMARY KEY (id)
);

CREATE TABLE Supplier(
  id SERIAL,
  name VARCHAR(255),
  description VARCHAR (255),
  PRIMARY KEY (id)
);

ALTER TABLE product
  ADD CONSTRAINT fk_product_supplier_id FOREIGN KEY (supplier_id) REFERENCES supplier(id);

ALTER TABLE product
  ADD CONSTRAINT fk_product_product_category_id FOREIGN KEY (product_category_id) REFERENCES product_category(id);

INSERT INTO product_category (name, department, description) VALUES ('Weapon', 'blabla', 'blabla');
INSERT INTO product_category (name, department, description) VALUES ('Mystic', 'blabla', 'blabla');
INSERT INTO product_category (name, department, description) VALUES ('Vehicle', 'blabla', 'blabla');
INSERT INTO product_category (name, department, description) VALUES ('Pet', 'blabla', 'blabla');
INSERT INTO product_category (name, department, description) VALUES ('Collectors Item', 'blabla', 'blabla');

INSERT INTO supplier (name, description) VALUES ('Earth-616', 'blabla');
INSERT INTO supplier (name, description) VALUES ('Middle-Earth', 'blabla');
INSERT INTO supplier (name, description) VALUES ('DC-Verse', 'blabla');
INSERT INTO supplier (name, description) VALUES ('Hogwarts', 'blabla');
INSERT INTO supplier (name, description) VALUES ('Faraway galaxy', 'blabla');

INSERT INTO product (name, default_price,currency_string,description,product_category_id,supplier_id)  VALUES ('Captain America''s Shield', 49.9, 'Credits',
                                                                                                               'Made from the strongest metal on earth, this one-of-a-kind shield will ' ||
                                                                                                               'keep you safe against all manner of enemies.', 1, 1);
INSERT INTO product (name, default_price,currency_string,description,product_category_id,supplier_id)  VALUES ('Sauron''s Ring', 49.9, 'Credits', 'Description here', 1, 2);
INSERT INTO product (name, default_price,currency_string,description,product_category_id,supplier_id)  VALUES ('Fury''s Lightsaber', 49.9, 'Credits', 'Description here', 1, 5);
INSERT INTO product (name, default_price,currency_string,description,product_category_id,supplier_id)  VALUES ('Gandalf the White''s Staff', 49.9, 'Credits', 'Description here', 1, 2);
INSERT INTO product (name, default_price,currency_string,description,product_category_id,supplier_id)  VALUES ('Elder Wand', 49.9, 'Credits', 'Description here', 1, 4);
INSERT INTO product (name, default_price,currency_string,description,product_category_id,supplier_id)  VALUES ('Lasso of Truth', 49.9, 'Credits', 'Description here', 2, 3);
INSERT INTO product (name, default_price,currency_string,description,product_category_id,supplier_id)  VALUES ('Cloak of Levitation', 49.9, 'Credits', 'Description here', 2, 1);
INSERT INTO product (name, default_price,currency_string,description,product_category_id,supplier_id)  VALUES ('Invisibility Cloak', 49.9, 'Credits', 'Description here', 2, 4);
INSERT INTO product (name, default_price,currency_string,description,product_category_id,supplier_id)  VALUES ('Kyber Crystal', 49.9, 'Credits', 'Description here', 2, 5);
INSERT INTO product (name, default_price,currency_string,description,product_category_id,supplier_id)  VALUES ('Sorting Hat', 49.9, 'Credits', 'Description here', 2, 4);
INSERT INTO product (name, default_price,currency_string,description,product_category_id,supplier_id)  VALUES ('The Millenium Falcon', 49.9, 'Credits', 'Description here', 3, 5);
INSERT INTO product (name, default_price,currency_string,description,product_category_id,supplier_id)  VALUES ('Batmobile', 49.9, 'Credits', 'Description here', 3, 3);
INSERT INTO product (name, default_price,currency_string,description,product_category_id,supplier_id)  VALUES ('Avengers'' Quinjet', 49.9, 'Credits', 'Description here', 3, 1);
INSERT INTO product (name, default_price,currency_string,description,product_category_id,supplier_id)  VALUES ('Flying Car', 49.9, 'Credits', 'Description here', 3, 4);
INSERT INTO product (name, default_price,currency_string,description,product_category_id,supplier_id)  VALUES ('Dum-E', 49.9, 'Credits', 'Description here', 4, 1);
INSERT INTO product (name, default_price,currency_string,description,product_category_id,supplier_id)  VALUES ('Porg', 49.9, 'Credits', 'Description here', 4, 5);
INSERT INTO product (name, default_price,currency_string,description,product_category_id,supplier_id)  VALUES ('Hedwig', 49.9, 'Credits', 'Description here', 4, 4);
INSERT INTO product (name, default_price,currency_string,description,product_category_id,supplier_id)  VALUES ('Shadowfax', 49.9, 'Credits', 'Description here', 4, 2);
INSERT INTO product (name, default_price,currency_string,description,product_category_id,supplier_id)  VALUES ('Serious Clown Make-up Kit', 49.9, 'Credits', 'Description here', 5, 3);
INSERT INTO product (name, default_price,currency_string,description,product_category_id,supplier_id)  VALUES ('Wakandan Bionic Arm', 49.9, 'Credits', 'Description here', 5, 1);
INSERT INTO product (name, default_price,currency_string,description,product_category_id,supplier_id)  VALUES ('Horn of Gondor', 49.9, 'Credits', 'Description here', 5, 2);
INSERT INTO product (name, default_price,currency_string,description,product_category_id,supplier_id)  VALUES ('Bane''s Mask', 49.9, 'Credits', 'Description here', 5, 3);
INSERT INTO product (name, default_price,currency_string,description,product_category_id,supplier_id)  VALUES ('Harry''s Glasses', 49.9, 'Credits', 'Description here', 5, 4);
