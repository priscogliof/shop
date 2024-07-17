CREATE TABLE users (
  id SERIAL PRIMARY KEY,
  username VARCHAR(50) NOT NULL,
  password VARCHAR(100) NOT NULL,
  email VARCHAR(100) NOT NULL,
  roles VARCHAR(50) NOT NULL
);

INSERT INTO users (username, password, email, roles)
VALUES ('admin', 'admin', 'admin@example.com', 'ADMIN'),
	   ('user', 'user', 'user@example.com', 'USER');

CREATE TABLE products (
  id INT PRIMARY KEY AUTO_INCREMENT,
  code VARCHAR(255) NOT NULL,
  name VARCHAR(255) NOT NULL,
  description TEXT,
  price DECIMAL(10, 2) NOT NULL,
  quantity INT NOT NULL,
  inventory_status VARCHAR(50) NOT NULL,
  category VARCHAR(100) NOT NULL,
  image VARCHAR(255),
  rating DECIMAL(3, 2)
);

INSERT INTO products (id, code, name, description, image, price, category, quantity, inventory_status, rating)
VALUES
  (1000, 'f230fh0g3', 'Bamboo Watch', 'Product Description', 'bamboo-watch.jpg', 65, 'Accessories', 24, 'INSTOCK', 5),
  (1001, 'nvklal433', 'Black Watch', 'Product Description', 'black-watch.jpg', 72, 'Accessories', 61, 'INSTOCK', 4),
  (1002, 'zz21cz3c1', 'Blue Band', 'Product Description', 'blue-band.jpg', 79, 'Fitness', 2, 'LOWSTOCK', 3),
  (1003, '244wgerg2', 'Blue T-Shirt', 'Product Description', 'blue-t-shirt.jpg', 29, 'Clothing', 25, 'INSTOCK', 5),
  (1004, 'h456wer53', 'Bracelet', 'Product Description', 'bracelet.jpg', 15, 'Accessories', 73, 'INSTOCK', 4),
  (1005, 'av2231fwg', 'Brown Purse', 'Product Description', 'brown-purse.jpg', 120, 'Accessories', 0, 'OUTOFSTOCK', 4);