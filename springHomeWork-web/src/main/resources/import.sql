
DROP TABLE IF EXISTS customers CASCADE;
CREATE TABLE IF NOT EXISTS customers (id bigserial PRIMARY KEY, name VARCHAR (255));
INSERT INTO customers(name) VALUES ('Bob'), ('Jack'), ('Tom'), ('Elvis');

DROP TABLE IF EXISTS products CASCADE;
CREATE TABLE IF NOT EXISTS products (id bigserial PRIMARY KEY, title VARCHAR (255), cost integer);
INSERT INTO products(title, cost) VALUES ('Potato', 40), ('Tomato', 250), ('Pepper', 167), ('Carrot', 35);

DROP TABLE IF EXISTS customers_products CASCADE;
CREATE TABLE IF NOT EXISTS customers_products (customer_id bigint, product_id bigint, FOREIGN KEY (customer_id) REFERENCES customers (id), FOREIGN KEY (product_id) REFERENCES products (id));
INSERT INTO customers_products (customer_id, product_id) VALUES (1, 1), (1, 2), (3, 1), (2, 1), (1, 3), (2, 2), (2, 3);


