CREATE TABLE public."pet_owner"
(
    id        varchar(10) NOT NULL,
    name      varchar     NOT NULL,
    address   varchar     NOT NULL,
    "version" int NULL,
    CONSTRAINT pet_owner_pk PRIMARY KEY (id)
);