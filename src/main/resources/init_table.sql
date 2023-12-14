DROP TABLE IF EXISTS products;
CREATE TABLE IF NOT EXISTS products (
    number BIGINT NOT NULL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    price DECIMAL(10, 2),
    type INT
);
