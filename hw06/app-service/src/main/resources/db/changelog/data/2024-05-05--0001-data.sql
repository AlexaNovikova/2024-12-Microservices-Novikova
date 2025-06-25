--liquibase formatted sql

--changeset alexaNovikova:2025-06-25-001-user_profile
insert into user_profile(id, login, age)
values (1, 'admin', 38);