-- create educ_nc_spring_19 database as user 'postgres'
-- CREATE DATABASE educ_nc_spring_19;
-- you must connect to 'educ_nc_spring_19' DB first and after it execute next statements

-- create user
CREATE USER master_data WITH PASSWORD 'master_data';
-- create schema
CREATE SCHEMA IF NOT EXISTS AUTHORIZATION master_data;

-- BEGIN CREATE TABLES
-- CREATE master_data.direction
CREATE TABLE master_data.direction
(
    id uuid NOT NULL,
    name character varying(255) COLLATE pg_catalog."default",
    description character varying(255) COLLATE pg_catalog."default",
    external_id character varying(255) COLLATE pg_catalog."default",
    created_date timestamp with time zone,
    created_by_user_id uuid,
    updated_date timestamp with time zone,
    updated_by_user_id uuid,
    CONSTRAINT direction_pkey PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE master_data.direction OWNER to master_data;
-- END master_data.direction

-- CREATE master_data.mentor
CREATE TABLE master_data.mentor
(
    id uuid NOT NULL,
    first_name character varying(255) COLLATE pg_catalog."default",
    last_name character varying(255) COLLATE pg_catalog."default",
    email_address character varying(255) COLLATE pg_catalog."default",
    phone_number character varying(255) COLLATE pg_catalog."default",
    description character varying(255) COLLATE pg_catalog."default",
    user_id uuid NOT NULL,
    direction_id uuid NOT NULL,
    acronym character varying(255) COLLATE pg_catalog."default",
    dept_name character varying(255) COLLATE pg_catalog."default",
    external_id character varying(255) COLLATE pg_catalog."default",
    created_date timestamp with time zone,
    created_by_user_id uuid,
    updated_date timestamp with time zone,
    updated_by_user_id uuid,
    CONSTRAINT mentor_pkey PRIMARY KEY (id),
    CONSTRAINT fk_mxfftm4fqcxy7toe23cweavl8 FOREIGN KEY (direction_id)
        REFERENCES master_data.direction (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE master_data.mentor OWNER to master_data;
-- END master_data.mentor

-- CREATE master_data.subdirection
CREATE TABLE master_data.subdirection
(
    id uuid NOT NULL,
    name character varying(255) COLLATE pg_catalog."default",
    description character varying(255) COLLATE pg_catalog."default",
    direction_id uuid NOT NULL,
    external_id character varying(255) COLLATE pg_catalog."default",
    created_date timestamp with time zone,
    created_by_user_id uuid,
    updated_date timestamp with time zone,
    updated_by_user_id uuid,
    CONSTRAINT subdirection_pkey PRIMARY KEY (id),
    CONSTRAINT fkwgkps7sdx3796el3f0918f4g FOREIGN KEY (direction_id)
        REFERENCES master_data.direction (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE master_data.subdirection OWNER to master_data;
-- END master_data.subdirection

-- CREATE master_data.student
CREATE TABLE master_data.student
(
    id uuid NOT NULL,
    first_name character varying(255) COLLATE pg_catalog."default",
    last_name character varying(255) COLLATE pg_catalog."default",
    email_address character varying(255) COLLATE pg_catalog."default",
    phone_number character varying(255) COLLATE pg_catalog."default",
    user_id uuid,
    direction_id uuid NOT NULL,
    subdirection_id uuid,
    external_id character varying(255) COLLATE pg_catalog."default",
    year_of_study integer,
    semester integer,
    tech_comment text COLLATE pg_catalog."default",
    hr_comment text COLLATE pg_catalog."default",
    interviewer_id uuid NOT NULL,
    created_date timestamp with time zone,
    created_by_user_id uuid,
    updated_date timestamp with time zone,
    updated_by_user_id uuid,
    CONSTRAINT student_pkey PRIMARY KEY (id),
    CONSTRAINT fk_nrnyktqy34m2bu66c9aftwfxo FOREIGN KEY (direction_id)
        REFERENCES master_data.direction (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fkcjoswpoyt149m3ct1sornihdv FOREIGN KEY (interviewer_id)
        REFERENCES master_data.mentor (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fks74g3d4iu7ygwtafvh048vww7 FOREIGN KEY (subdirection_id)
        REFERENCES master_data.subdirection (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE master_data.student OWNER to master_data;
-- END master_data.student
-- END CREATE TABLES