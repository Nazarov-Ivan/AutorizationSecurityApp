create table person
(
    id            integer generated by default as identity
        primary key,
    username      varchar(100) not null,
    year_of_birth integer      not null,
    password      varchar      not null
);

alter table person
    owner to postgres;

INSERT INTO public.person (id, username, year_of_birth, password) VALUES (4, 'user', 2000, '$2a$10$fOZ2idUbwiAAsu0NttaQyuZPVk3NZXbhcN856rpgXyFz1sgnMk0vS');
INSERT INTO public.person (id, username, year_of_birth, password) VALUES (3, 'admin', 1995, '$2a$10$APcoZBhAEe/jmdlrKcHlbOhdKf96Bn1/Yxj3OIh.4PMsqNTnExz6W');
INSERT INTO public.person (id, username, year_of_birth, password) VALUES (5, 'editor', 1990, '$2a$10$sRUo0QKyqmAEEhTyGe0gM.CAj/7N4aGMdzTv8ILQqqWCvVTjQCf0e');
