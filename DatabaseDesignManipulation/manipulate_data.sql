--script to delete, update and select data from the 'users' table

-- Select all users
SELECT * FROM users;
-- Update the email of a user
UPDATE users
SET email = 'john@gmail.com'
WHERE username = 'john doe';
-- Delete a user from the table
DELETE FROM users
WHERE username = 'bob_brown';


-- Select a specific user
SELECT * FROM users
WHERE username = 'jane smith';
-- Select users with a specific condition
SELECT * FROM users
WHERE created_at > '2023-01-01';