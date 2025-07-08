CREATE TABLE book (
    id bigint PRIMARY KEY GENERATED ALWAYS AS IDENTITY UNIQUE,
    name varchar NOT NULL,
    author varchar NOT NULL,
    status bool NOT NULL
);