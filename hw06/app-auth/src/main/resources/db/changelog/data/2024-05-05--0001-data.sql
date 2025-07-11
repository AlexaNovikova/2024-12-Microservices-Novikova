--liquibase formatted sql

--changeset alexaNovikova:2025-06-25-001-auth_user
insert into auth_user(login, password, email, first_name, last_name)
values ('admin', 'admin', 'admin@mail.ru', 'admin', 'admin');