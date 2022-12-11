create table authorities
(
    id    serial
        constraint authorities_pk
            primary key,
    admin varchar,
    hello varchar
);

alter table authorities
    owner to postgres;

create unique index authorities_id_uindex
    on authorities (id);

INSERT INTO public.authorities (id, admin, hello) VALUES (1, 'edit_admin', 'edit_hello');
INSERT INTO public.authorities (id, admin, hello) VALUES (2, '', 'read_hello');
INSERT INTO public.authorities (id, admin, hello) VALUES (3, 'closed_admin', '');
