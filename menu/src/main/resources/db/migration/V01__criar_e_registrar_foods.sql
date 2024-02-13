CREATE TABLE foods
(
    id SERIAL PRIMARY KEY,
    title TEXT NOT NULL,
    image TEXT,
    price double precision
);

INSERT INTO foods (title, image, price) VALUES ('Lasanha a Bolonhesa', 'https://duckduckgo.com/?q=lasanha+a+bolonhesa&atb=v416-5&iax=images&ia=images&iai=https%3A%2F%2Fi.ytimg.com%2Fvi%2Fwm_C0Un8QSU%2Fmaxresdefault.jpg', 54.95);