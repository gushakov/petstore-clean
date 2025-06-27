CREATE TABLE public."pet_owner"
(
    id        varchar(10) NOT NULL,
    name      varchar     NOT NULL,
    address   varchar     NOT NULL,
    "version" int NULL,
    CONSTRAINT pet_owner_pk PRIMARY KEY (id)
);

INSERT INTO public."pet_owner" (id, name, address, "version")
VALUES ('per_a7x2m9', 'Sarah Johnson', '123 Oak Street, Springfield, IL 62701', 1),
       ('per_k4b8n3', 'Michael Chen', '456 Maple Avenue, Austin, TX 78701', 1),
       ('per_z9q5r1', 'Emily Rodriguez', '789 Pine Lane, Portland, OR 97201', 2),
       ('per_f3h7s6', 'David Thompson', '321 Elm Drive, Denver, CO 80202', 1),
       ('per_w2j8t4', 'Jessica Williams', '654 Cedar Court, Seattle, WA 98101', 3),
       ('per_y5l1u9', 'Robert Martinez', '987 Birch Road, Phoenix, AZ 85001', 1),
       ('per_c8v3p7', 'Amanda Davis', '147 Willow Way, Miami, FL 33101', 2),
       ('per_n6g2d5', 'Christopher Lee', '258 Spruce Street, Boston, MA 02101', 1),
       ('per_r4e9m8', 'Lisa Anderson', '369 Ash Boulevard, Chicago, IL 60601', 4),
       ('per_i7o1x3', 'Kevin Brown', '741 Hickory Place, San Diego, CA 92101', 1);