-- Create the database if it doesn't exist
CREATE DATABASE IF NOT EXISTS utchikanna_neelakandan_corejava_project;

-- Use the database
USE utchikanna_neelakandan_corejava_project;

-- Create the 'user' table
CREATE TABLE IF NOT EXISTS user (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    password VARCHAR(200) NOT NULL,
    phone_no VARCHAR(20) NOT NULL,
    email VARCHAR(100) NOT NULL,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL
);

-- Create the 'movie' table
CREATE TABLE IF NOT EXISTS movie (
    movie_rating VARCHAR(20) NOT NULL,
    movie_title VARCHAR(50) NOT NULL,
    movie_id INT AUTO_INCREMENT PRIMARY KEY,
    movie_image_url VARCHAR(2048) NOT NULL,
    isActive BOOLEAN NOT NULL DEFAULT TRUE
);

-- Create the 'comment' table
CREATE TABLE IF NOT EXISTS comment (
    comment_id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    comment VARCHAR(500) NOT NULL,
    movie_id INT,
    FOREIGN KEY (movie_id) REFERENCES movie (movie_id)
);

-- Create the 'rating' table
CREATE TABLE IF NOT EXISTS rating (
    rating_id INT AUTO_INCREMENT PRIMARY KEY,
    rating INT NOT NULL,
    movie_id INT,
    user_id INT,
    FOREIGN KEY (user_id) REFERENCES user (user_id),
    FOREIGN KEY (movie_id) REFERENCES movie (movie_id)
);

-- Create the 'feedback' table
CREATE TABLE IF NOT EXISTS feedback (
    feedback_id INT AUTO_INCREMENT PRIMARY KEY,
    feedback VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL,
    user_id INT
);

-- Insert sample records into the 'user' table
INSERT INTO user (password, phone_no, email, first_name, last_name)
VALUES
    ('password1', '1234567890', 'user1@example.com', 'John', 'Doe');
    

-- Insert sample records into the 'movie' table
INSERT INTO movie (movie_rating, movie_title, movie_image_url, isActive)
VALUES
    ('R', 'Movie 2', 'http://example.com/movie2.jpg', TRUE);

-- Insert sample records into the 'comment' table
INSERT INTO comment (first_name, comment, movie_id)
VALUES

    ('John', 'A must-watch!', 1);

-- Insert sample records into the 'rating' table
INSERT INTO rating (rating, movie_id, user_id)
VALUES
 
    (4, 1, 1);

-- Insert sample records into the 'feedback' table
INSERT INTO feedback (feedback, email, user_id)
VALUES
  
    ('Good experience', 'user2@example.com', 1);
