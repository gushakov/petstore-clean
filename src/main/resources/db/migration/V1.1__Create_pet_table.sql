CREATE TABLE public.pet
(
    id             varchar(10) NOT NULL,
    name           varchar     NOT NULL,
    kind_of_animal varchar     NOT NULL,
    age            int         NOT NULL,
    pet_owner_id   varchar(10) NOT NULL,
    "version"      int NULL,
    CONSTRAINT pet_pk PRIMARY KEY (id),
    CONSTRAINT pet_pet_owner_fk FOREIGN KEY (pet_owner_id) REFERENCES public.pet_owner (id)
);
