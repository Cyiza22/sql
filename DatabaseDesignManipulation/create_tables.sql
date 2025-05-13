-- This SQL script creates a table named 'users' with the following columns:
CREATE TABLE  Books (
    book_id SERIAL PRIMARY KEY,
    tittle VARCHAR(50) NOT NULL,
    author VARCHAR(255) NOT NULL,
    genre VARCHAR(100) NOT NULL,
    Price DECIMAL(10, 2) NOT NULL,
    stock INT NOT NULL
);

CREATE TABLE customers(
    customer_id SERIAL PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    phone VARCHAR(15) NOT NULL UNIQUE,
    address TEXT NOT NULL
);
CREATE TABLE orders(
    order_id SERIAL PRIMARY KEY,
    customer_id INT REFERENCES customers(customer_id),
    book_id INT REFERENCES Books(book_id),
    order_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);