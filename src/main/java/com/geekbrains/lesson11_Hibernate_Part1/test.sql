-- DROP table public.books;
-- DROP table public.author_details;
-- DROP table public.authors;



-- select * from books;

-- select * from authors;

-- select * from author_details;

-- select * from readers;

-- select * from readers_books;
 
-- select authors.name as author, books.title as book_name, books.releaseyear from 
-- books join authors on books.author_id = authors.id;


-- UPDATE authors SET details = 1 WHERE authors.id = 1;

INSERT INTO authors (name) 
VALUES 
('John'),
('Pol'),
('Mike'),
('Bruce'),
('Ivan');

INSERT INTO books (title, releaseyear, author_id) 
VALUES 
('book1', 1983, 1),
('book2', 2000, 1),
('book3', 2005, 3),
('book4', 1995, 2),
('book5', 2012, 4);

INSERT INTO author_details 
VALUES 
(30, 1, 'Moscow');
-- (43, 'Samara'),
-- (46, 'Penza'),
-- (53, 'Moscow'),
-- (24, 'sochi');

INSERT INTO readers (name, age)
VALUES
('Petr', 18),
('Max', 29),
('Gena', 34),
('Mike', 30),
('Nik', 45);

INSERT INTO readers_books (readers_id, books_id)
VALUES
(1, 3),
(1, 2),
(2, 3),
(4, 1),
(3, 1);

