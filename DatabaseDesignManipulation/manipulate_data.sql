--script to delete, update and select data from the Books,customers and orders tables

-- Select all users
SELECT * FROM Books;
SELECT * FROM customers;
SELECT * FROM orders;
-- Update the tables
UPDATE Books
SET tittle = 'To Kill a Mockingbird', author = 'john doe'
WHERE book_id = 2;


UPDATE customers
SET first_name = 'Jane', customer_id = 9
WHERE last_name = 'Smith';

UPDATE orders
SET customer_id = 3, order_id = 90
WHERE book_id = 2;

-- Delete a user from the tables
DELETE FROM Books
WHERE book_id = 1;

DELETE FROM customers
WHERE customer_id = 9;


-- Select a specific part of the tables
SELECT * FROM Books
WHERE book_id = 2;

SELECT b.tittle FROM Books b; 
SELECT b.tittle, b.author FROM Books b;
SELECT b.tittle, b.author, b.Price FROM Books b;

SELECT * FROM customers
WHERE customer_id = 3;

SELECT * FROM orders
WHERE order_id = 1;

-- Select tables with a specific condition
SELECT * FROM Books
WHERE Price > 10;

SELECT * FROM customers
WHERE first_name = 'Jane';

SELECT * FROM orders
WHERE order_date > '2023-01-01';