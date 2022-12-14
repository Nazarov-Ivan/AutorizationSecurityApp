create table resources
(
    id   serial
        constraint resources_pk
            primary key,
    name varchar not null
);

alter table resources
    owner to postgres;

create unique index resources_id_uindex
    on resources (id);

INSERT INTO public.resources (id, name) VALUES (1, 'admin');
INSERT INTO public.resources (id, name) VALUES (2, 'hello');
