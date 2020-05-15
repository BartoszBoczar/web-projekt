INSERT INTO movies (title, description) VALUES('Title', 'Description');

INSERT INTO halls VALUES(1);

INSERT INTO seats (hall_id, seat_row, seat_column) VALUES(1, 1, 1);

INSERT INTO screenings (movie_id, hall_id, begin_time, duration, price) VALUES(1, 1, '2020-05-15 12:30:00', 123, 27.99);

INSERT INTO reservations (screening_id, name, surname, email) VALUES(1, 'John', 'Doe', 'john-doe@gmail.com');

INSERT INTO reservations_seats (screening_id, seat_id, discount) VALUES(1, 1, 'STUDENT');