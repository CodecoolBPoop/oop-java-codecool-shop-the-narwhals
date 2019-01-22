
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

INSERT INTO supplier (name, description) VALUES ('Earth-616', 'blabla');

INSERT INTO product_category (name, department, description) VALUES ('Weapon', 'blabla', 'blabla');

INSERT INTO product (name, default_price,currency_string,description,product_category_id,supplier_id)  VALUES ('Captain America''s Shield', 49.9, 'Credits', 'Made from the strongest metal on earth, this one-of-a-kind shield will
 keep you safe against all manner of enemies.', 1, 1);