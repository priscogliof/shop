CREATE TABLE users (

  id INT PRIMARY KEY AUTO_INCREMENT,

  username VARCHAR(255) NOT NULL,

  password VARCHAR(255) NOT NULL,

  email VARCHAR(255) NOT NULL,

  roles VARCHAR(255) NOT NULL

);

INSERT INTO users (username, password, email, roles)
VALUES ('admin', 'admin', 'admin@example.com', 'Admin');