INSERT INTO MEMBER (email_address, hashed_password, first_name, last_name, date_of_birth, last_four_digits, card_type, expiration_date) VALUES
('john.doe@example.com', 'hashedpassword123', 'John', 'Doe', '1990-01-01', '1234', 'Visa', '2024-12-31');

INSERT INTO DIRECTOR (first_name, last_name) VALUES
('Steven', 'Spielberg');

INSERT INTO GENRE (genre_type) VALUES
('Action');

INSERT INTO MOVIE (movie_name, release_year, rental_cost) VALUES
('Jurassic Park', 1993, 2.99);

-- Assuming the first inserted rows have ID = 1
INSERT INTO MOVIE_DIRECTOR (movie_ID, director_ID) VALUES
(1, 1);

INSERT INTO MOVIE_GENRE (movie_ID, genre_ID) VALUES
(1, 1);

INSERT INTO REVIEW (review_description, rating, member_ID, movie_ID) VALUES
('Great movie!', 5, 1, 1);

INSERT INTO RENTAL (rental_date, return_date, member_ID, movie_ID) VALUES
('2024-02-23', '2024-02-26', 1, 1);

INSERT INTO PAYMENT (amount, payment_date, rental_ID, member_ID) VALUES
(2.99, '2024-02-23', 1, 1);

