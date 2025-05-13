-- script for inserting data into the 'Books' table
INSERT INTO Books ( tittle, author, genre, Price, stock)
VALUES
    ('The Great Gatsby', 'F. Scott Fitzgerald', 'Fiction', 10.99, 100),
    ('To Kill a Mockingbird', 'Harper Lee', 'Fiction', 12.99, 50),
    ('1984', 'George Orwell', 'Dystopian', 15.99, 75),
    ('Pride and Prejudice', 'Jane Austen', 'Romance', 8.99, 200),
    ('The Catcher in the Rye', 'J.D. Salinger', 'Fiction', 14.99, 30),
    ('The Hobbit', 'J.R.R. Tolkien', 'Fantasy', 9.99, 120),
    ('Fahrenheit 451', 'Ray Bradbury', 'Dystopian', 11.99, 60),
    ('Brave New World', 'Aldous Huxley', 'Dystopian', 13.99, 40),
    ('The Alchemist', 'Paulo Coelho', 'Adventure', 10.49, 80)
;

-- script for inserting data into the 'customers' table
INSERT INTO customers (first_name, last_name, email, phone, address)
VALUES
    ('John', 'Doe', 'johndoe@gmai.com', '123-456-7890', '123 Elm St, Springfield'),
    ('Jane', 'Smith', 'janesmith@gmail.com', '987-654-3210', '456 Oak St, Springfield'),
    ('Bob', 'Brown', 'bob@gmail.com', '555-555-5555', '789 Pine St, Springfield'),
    ('Alice', 'Johnson', 'alice@company.com', '444-444-4444', '321 Maple St, Springfield'),
    ('Charlie', 'Davis', 'charlie@student.com', '222-222-2222', '654 Cedar St, Springfield')
;

-- script for inserting data into the orders table
INSERT INTO orders (customer_id, book_id)
VALUES (1, 3), (2, 5), (1, 7);
    
