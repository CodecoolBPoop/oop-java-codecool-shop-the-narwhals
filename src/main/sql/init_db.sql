
DROP TABLE IF EXISTS product CASCADE;
DROP TABLE IF EXISTS product_category CASCADE;
DROP TABLE IF EXISTS supplier CASCADE;



CREATE TABLE Product(
  id INT NOT NULL,
  name VARCHAR(255),
  default_price FLOAT,
  currency_string VARCHAR (7),
  description VARCHAR (255),
  product_category_id INT NOT NULL,
  supplier_id INT NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE Product_Category(
  id INT NOT NULL,
  name VARCHAR(255),
  department VARCHAR (255),
  description VARCHAR (255),
  PRIMARY KEY (id)
);

CREATE TABLE Supplier(
  id INT NOT NULL,
  name VARCHAR(255),
  description VARCHAR (255),
  PRIMARY KEY (id)
);

