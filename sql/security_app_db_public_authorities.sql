create table authorities
(
    id          serial
        constraint authorities_pk
            primary key,
    resource_id integer
        references resources,
    role_id     integer
        references roles,
    access      varchar
);

alter table authorities
    owner to postgres;

create unique index authorities_id_uindex
    on authorities (id);

INSERT INTO public.authorities (id, resource_id, role_id, access) VALUES (2, 1, 2, 'close_admin');
INSERT INTO public.authorities (id, resource_id, role_id, access) VALUES (1, 1, 1, 'edit_admin');
INSERT INTO public.authorities (id, resource_id, role_id, access) VALUES (4, 2, 2, 'read_user');
INSERT INTO public.authorities (id, resource_id, role_id, access) VALUES (3, 2, 1, 'edit_user');
