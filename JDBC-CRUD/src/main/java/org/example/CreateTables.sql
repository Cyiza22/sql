CREATE TABLE IF NOT EXISTS Students(
    id SERIAL PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    date_of_birth DATE NOT NULL
);

CREATE TABLE IF NOT EXISTS Courses(
    id SERIAL PRIMARY KEY,
    course_name VARCHAR(100) UNIQUE,
    course_description TEXT
);


CREATE TABLE IF NOT EXISTS Marks(
    student_id INT REFERENCES Students(id) ON DELETE CASCADE,
    courses_id INT REFERENCES Courses(id) ON DELETE CASCADE,
    marks FLOAT NOT NULL,
    PRIMARY KEY(student_id, courses_id)
);


select * FROM Courses;