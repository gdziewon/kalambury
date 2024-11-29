CREATE DATABASE IF NOT EXISTS puns;
USE puns;

CREATE TABLE IF NOT EXISTS users (
                       id INT AUTO_INCREMENT PRIMARY KEY,
                       username VARCHAR(50) NOT NULL UNIQUE,
                       created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS games (
                       id INT AUTO_INCREMENT PRIMARY KEY,
                       start_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                       end_time TIMESTAMP NULL,
                       status ENUM('active', 'finished') DEFAULT 'active'
);

CREATE TABLE IF NOT EXISTS game_players (
                              id INT AUTO_INCREMENT PRIMARY KEY,
                              game_id INT NOT NULL,
                              user_id INT NOT NULL,
                              score INT DEFAULT 0,
                              FOREIGN KEY (game_id) REFERENCES games(id) ON DELETE CASCADE,
                              FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS words (
                       id INT AUTO_INCREMENT PRIMARY KEY,
                       word VARCHAR(100) NOT NULL UNIQUE,
                       category VARCHAR(50) DEFAULT NULL
);

CREATE TABLE IF NOT EXISTS game_words (
                            id INT AUTO_INCREMENT PRIMARY KEY,
                            game_id INT NOT NULL,
                            word_id INT NOT NULL,
                            guessed BOOLEAN DEFAULT FALSE,
                            FOREIGN KEY (game_id) REFERENCES games(id) ON DELETE CASCADE,
                            FOREIGN KEY (word_id) REFERENCES words(id) ON DELETE CASCADE
);
