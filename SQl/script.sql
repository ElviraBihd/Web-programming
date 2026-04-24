CREATE TABLE movies(
    id SERIAL PRIMARY KEY,
    name VARCHAR(160),
    age_limit int,
    type VARCHAR(150),
    director VARCHAR(150)
);

INSERT INTO movies(name, age_limit, type, director)
VALUES('The Fast and Furious', 12, 'Action', 'Rob Cohen'),
      ('Bad Boys', '15', 'Action', 'Micheal Bay')

SELECT * FROM movies;