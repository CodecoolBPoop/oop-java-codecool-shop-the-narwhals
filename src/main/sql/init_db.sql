
DROP TABLE IF EXISTS product CASCADE;
DROP TABLE IF EXISTS product_category CASCADE;
DROP TABLE IF EXISTS supplier CASCADE;
DROP TABLE IF EXISTS line_item CASCADE;
DROP TABLE IF EXISTS order_info CASCADE;
DROP TABLE IF EXISTS contact_info CASCADE;



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

CREATE TABLE Line_Item(
  id SERIAL,
  number_of_products INT,
  name VARCHAR(255),
  description VARCHAR(255),
  product_id INT,
  order_info_id INT,
  PRIMARY KEY (id)
);

CREATE TABLE Order_Info(
  id SERIAL,
  name VARCHAR(255),
  description VARCHAR (255),
  total_sum INT,
  currency VARCHAR (255),
  contact_info_id INT,
  PRIMARY KEY (id)
);

CREATE TABLE Contact_Info(
  id SERIAL,
  name VARCHAR(255),
  email VARCHAR (255),
  phone_number VARCHAR (255),
  billing_address VARCHAR (255),
  shipping_address VARCHAR (255),
  order_info_id INT,
  PRIMARY KEY (id)
);

ALTER TABLE Order_Info
  ADD CONSTRAINT fk_contact_info_id FOREIGN KEY (contact_info_id) REFERENCES contact_info(id);

ALTER TABLE Product
  ADD CONSTRAINT fk_product_supplier_id FOREIGN KEY (supplier_id) REFERENCES supplier(id);

ALTER TABLE Product
  ADD CONSTRAINT fk_product_product_category_id FOREIGN KEY (product_category_id) REFERENCES product_category(id);

ALTER TABLE Line_Item
  ADD CONSTRAINT fk_product_id FOREIGN KEY (product_id) REFERENCES product(id);

ALTER TABLE Line_Item
  ADD CONSTRAINT fk_order_info_id FOREIGN KEY (order_info_id) REFERENCES order_info(id);

ALTER TABLE Contact_Info
  ADD CONSTRAINT fk_order_info_id FOREIGN KEY (order_info_id) REFERENCES order_info(id);

INSERT INTO product_category (name, department, description) VALUES ('Weapon', 'Pointy things', 'These items have hurty ends. Sometimes more than one.');
INSERT INTO product_category (name, department, description) VALUES ('Mystic', 'Magical things', 'Where science fails');
INSERT INTO product_category (name, department, description) VALUES ('Vehicle', 'Fast things', 'Things you can crash with style');
INSERT INTO product_category (name, department, description) VALUES ('Pet', 'Furry things', 'Dumb but lovable');
INSERT INTO product_category (name, department, description) VALUES ('Collectors Item', 'Baubly things', 'Worth is in the eye of the beholder');

INSERT INTO supplier (name, description) VALUES ('Earth-616', 'Be a hero');
INSERT INTO supplier (name, description) VALUES ('Middle-Earth', 'Go on grand adventures');
INSERT INTO supplier (name, description) VALUES ('DC-Verse', 'Be an inferior hero type');
INSERT INTO supplier (name, description) VALUES ('Hogwarts', 'Congratulations you got an owl');
INSERT INTO supplier (name, description) VALUES ('Faraway galaxy', 'Only siths deal in absolutes');

INSERT INTO product (name, default_price,currency_string,description,product_category_id,supplier_id)  VALUES ('Captain America''s Shield', 49.9, 'Credits', 'Excellent arc reactor destroyer', 1, 1);
INSERT INTO product (name, default_price,currency_string,description,product_category_id,supplier_id)  VALUES ('Sauron''s Ring', 49.9, 'Credits', 'Rule them all. Warning: Risk of finger-loss.', 1, 2);
INSERT INTO product (name, default_price,currency_string,description,product_category_id,supplier_id)  VALUES ('Mace''s Lightsaber', 49.9, 'Credits', 'Stand out from the Jedi crowd with this colourful lightsaber.', 1, 5);
INSERT INTO product (name, default_price,currency_string,description,product_category_id,supplier_id)  VALUES ('Gandalf the White''s Staff', 49.9, 'Credits', 'Be wiser than most, but avoid Balrogs.', 1, 2);
INSERT INTO product (name, default_price,currency_string,description,product_category_id,supplier_id)  VALUES ('Elder Wand', 49.9, 'Credits', 'Become all-powerful. Invest in bodyguards.', 1, 4);
INSERT INTO product (name, default_price,currency_string,description,product_category_id,supplier_id)  VALUES ('Lasso of Truth', 49.9, 'Credits', 'Now you can find out why your loved ones REALLY left you on read.', 2, 3);
INSERT INTO product (name, default_price,currency_string,description,product_category_id,supplier_id)  VALUES ('Cloak of Levitation', 49.9, 'Credits', 'Sentient and sassy piece of cloth for a bargain!', 2, 1);
INSERT INTO product (name, default_price,currency_string,description,product_category_id,supplier_id)  VALUES ('Invisibility Cloak', 49.9, 'Credits', 'Avoid chores and responsibilites!', 2, 4);
INSERT INTO product (name, default_price,currency_string,description,product_category_id,supplier_id)  VALUES ('Kyber Crystal', 49.9, 'Credits', 'Component of the DIY make your own lightsaber kit.', 2, 5);
INSERT INTO product (name, default_price,currency_string,description,product_category_id,supplier_id)  VALUES ('Sorting Hat', 49.9, 'Credits', 'Find out where you belong, argue it''s not Slytherin.', 2, 4);
INSERT INTO product (name, default_price,currency_string,description,product_category_id,supplier_id)  VALUES ('The Millenium Falcon', 49.9, 'Credits', 'This ship can complete the Kessel Run in 12 parsecs.', 3, 5);
INSERT INTO product (name, default_price,currency_string,description,product_category_id,supplier_id)  VALUES ('Batmobile', 49.9, 'Credits', 'Put the pedal to the medal, free voice changer included.', 3, 3);
INSERT INTO product (name, default_price,currency_string,description,product_category_id,supplier_id)  VALUES ('Avengers'' Quinjet', 49.9, 'Credits', 'Fly around unseen! Avengers not included.', 3, 1);
INSERT INTO product (name, default_price,currency_string,description,product_category_id,supplier_id)  VALUES ('Flying Car', 49.9, 'Credits', 'Avoid treelines in this magical ride!', 3, 4);
INSERT INTO product (name, default_price,currency_string,description,product_category_id,supplier_id)  VALUES ('Dum-E', 49.9, 'Credits', 'He may be dumb, but he means well. TS approved.', 4, 1);
INSERT INTO product (name, default_price,currency_string,description,product_category_id,supplier_id)  VALUES ('Porg', 49.9, 'Credits', 'Excellent as home security systems, or turkey alternatives.', 4, 5);
INSERT INTO product (name, default_price,currency_string,description,product_category_id,supplier_id)  VALUES ('Hedwig', 49.9, 'Credits', 'Forget snailmail, use owlmail!', 4, 4);
INSERT INTO product (name, default_price,currency_string,description,product_category_id,supplier_id)  VALUES ('Shadowfax', 49.9, 'Credits', 'Fastest living horse. May disappear when not needed.', 4, 2);
INSERT INTO product (name, default_price,currency_string,description,product_category_id,supplier_id)  VALUES ('Serious Clown Make-up Kit', 49.9, 'Credits', 'Why so serious?', 5, 3);
INSERT INTO product (name, default_price,currency_string,description,product_category_id,supplier_id)  VALUES ('Wakandan Bionic Arm', 49.9, 'Credits', 'May cause amnesia and murderous intent.', 5, 1);
INSERT INTO product (name, default_price,currency_string,description,product_category_id,supplier_id)  VALUES ('Horn of Gondor', 49.9, 'Credits', 'Raise dead heroes. Wear arrow-proof vest during use.', 5, 2);
INSERT INTO product (name, default_price,currency_string,description,product_category_id,supplier_id)  VALUES ('Bane''s Mask', 49.9, 'Credits', 'Instant delivery pain medication, with moderate side-effects.', 5, 3);
INSERT INTO product (name, default_price,currency_string,description,product_category_id,supplier_id)  VALUES ('Harry''s Glasses', 49.9, 'Credits', 'See the world through the short-sighted eyes of the Boy Who Lived.', 5, 4);
