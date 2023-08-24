create database if not exists utchikanna_neelakandan_corejava_project;

use utchikanna_neelakandan_corejava_project;


CREATE TABLE IF NOT EXISTS user (
user_id INT AUTO_INCREMENT PRIMARY KEY,
password VARCHAR(50),
phone_no VARCHAR(20),
email VARCHAR(100) not null,
first_name VARCHAR(50) not null,
last_name VARCHAR(50) not null
);


CREATE TABLE IF NOT EXISTS movie (
movie_rating VARCHAR(20),
movie_title VARCHAR(50),
movie_id INT not null PRIMARY KEY,
movie_image_url VARCHAR(2048) 
);

CREATE TABLE IF NOT EXISTS comment (
first_name VARCHAR(50) ,
comment_id INT not null PRIMARY KEY,
comment VARCHAR(500),
movie_id INT 
);

CREATE TABLE IF NOT EXISTS rating (
rating_id INT not null PRIMARY KEY,
rating INT,
movie_id INT ,
user_id INT,
  FOREIGN KEY (user_id) REFERENCES user(user_id),
    FOREIGN KEY (movie_id) REFERENCES movie(movie_id)
);

CREATE TABLE IF NOT EXISTS feedback (
feedback_id VARCHAR(20)not null PRIMARY KEY,
feedback VARCHAR(50),
email VARCHAR(100) ,
uesr_id INT
);




