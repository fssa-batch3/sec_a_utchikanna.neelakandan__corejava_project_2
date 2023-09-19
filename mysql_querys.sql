-- Create the database if it doesn't exist
CREATE DATABASE IF NOT EXISTS utchikanna_neelakandan_corejava_project;

-- Use the database
USE utchikanna_neelakandan_corejava_project;

-- Create the 'users' table
CREATE TABLE IF NOT EXISTS users (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    password VARCHAR(200) NOT NULL,
    phone_no VARCHAR(20) NOT NULL,
    email VARCHAR(100) NOT NULL,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    isActive BOOLEAN NOT NULL DEFAULT TRUE
);

-- Create the 'movies' table
CREATE TABLE IF NOT EXISTS movies (
    movie_rating VARCHAR(20) NOT NULL,
    movie_title VARCHAR(50) NOT NULL,
    movie_id INT AUTO_INCREMENT PRIMARY KEY,
    movie_image_url VARCHAR(2048) NOT NULL,
    isActive BOOLEAN NOT NULL DEFAULT TRUE
);
 ALTER TABLE `utchikanna_neelakandan_corejava_project`.`movies` 
ADD COLUMN `movie_trailer` VARCHAR(2048) NOT NULL AFTER `isActive`,
ADD COLUMN `movie_type` VARCHAR(50) NOT NULL AFTER `movie_trailer`;
-- Create the 'comments' table
CREATE TABLE IF NOT EXISTS comments (
    comment_id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    comment VARCHAR(500) NOT NULL,
    movie_id INT,
    FOREIGN KEY (movie_id) REFERENCES movies (movie_id)
);

-- Create the 'ratings' table
CREATE TABLE IF NOT EXISTS ratings (
    rating_id INT AUTO_INCREMENT PRIMARY KEY,
    rating INT NOT NULL,
    movie_id INT,
    user_id INT,
    FOREIGN KEY (user_id) REFERENCES users (user_id),
    FOREIGN KEY (movie_id) REFERENCES movies (movie_id)
);

-- Create the 'feedbacks' table
CREATE TABLE IF NOT EXISTS feedbacks (
    feedback_id INT AUTO_INCREMENT PRIMARY KEY,
    feedback VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL,
    user_id INT
);
CREATE TABLE IF NOT EXISTS movieDetails (
    movie_details_id INT AUTO_INCREMENT PRIMARY KEY,
	movie_id INT,
    story TEXT,                   -- Movie story
    release_date DATE,             -- Release date
	award_name VARCHAR(255),       -- Award name
    award_wiki VARCHAR(2048),      -- URL for award details
    movie_link VARCHAR(2048),      -- URL for watching the movie
	FOREIGN KEY (movie_id) REFERENCES movies (movie_id)
    );
    
    CREATE TABLE IF NOT EXISTS castAndCrew (
    cast_id INT AUTO_INCREMENT PRIMARY KEY,
    movie_id INT,
	director_name VARCHAR(255),    -- Director's name
    music_director_name VARCHAR(255),   -- Music director's name
    director_wiki VARCHAR(2048),   -- URL for director's Wikipedia page
    music_director_wiki VARCHAR(2048),  -- URL for music director's Wikipedia page
    actor_wiki VARCHAR(2048),     -- URL for actor 1's Wikipedia page
    actor_img VARCHAR(2048),      -- URL for actor 1's image
    actor_name VARCHAR(255),      -- Actor 1's name
	FOREIGN KEY (movie_id) REFERENCES movies (movie_id)
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
    
