-- create educ_nc_spring_19 database as user 'postgres'
-- CREATE DATABASE educ_nc_spring_19;
-- you must connect to 'educ_nc_spring_19' DB first and after it execute next statements

-- create user
CREATE USER master_data WITH PASSWORD 'master_data';
-- drop schema
-- DROP SCHEMA IF EXISTS master_data CASCADE;
-- create schema
CREATE SCHEMA IF NOT EXISTS AUTHORIZATION master_data;

-- BEGIN CREATE TABLES
-- CREATE master_data.direction
CREATE TABLE master_data.direction (
    id uuid PRIMARY KEY,
    name character varying(255) COLLATE pg_catalog."default",
    description character varying(255) COLLATE pg_catalog."default",
    external_id character varying(255) COLLATE pg_catalog."default" UNIQUE NOT NULL,
    created_date timestamp with time zone,
    created_by_user_id uuid,
    updated_date timestamp with time zone,
    updated_by_user_id uuid
) WITH (
    OIDS = FALSE
) TABLESPACE pg_default;

ALTER TABLE master_data.direction OWNER to master_data;
-- END master_data.direction

-- CREATE master_data.subdirection
CREATE TABLE master_data.subdirection (
    id uuid PRIMARY KEY,
    name character varying(255) COLLATE pg_catalog."default",
    description character varying(255) COLLATE pg_catalog."default",
    direction_id uuid,
    ext_direction_id character varying(255) COLLATE pg_catalog."default",
    external_id character varying(255) COLLATE pg_catalog."default" UNIQUE NOT NULL,
    created_date timestamp with time zone,
    created_by_user_id uuid,
    updated_date timestamp with time zone,
    updated_by_user_id uuid,
    CONSTRAINT fk_direction_id FOREIGN KEY (direction_id)
        REFERENCES master_data.direction (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
) WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE master_data.subdirection OWNER to master_data;
-- END master_data.subdirection

-- CREATE master_data.mentor
CREATE TABLE master_data.mentor (
    id uuid PRIMARY KEY,
    first_name character varying(255) COLLATE pg_catalog."default",
    last_name character varying(255) COLLATE pg_catalog."default",
    email_address character varying(255) COLLATE pg_catalog."default",
    phone_number character varying(255) COLLATE pg_catalog."default",
    description character varying(255) COLLATE pg_catalog."default",
    user_id uuid,
    direction_id uuid,
    ext_direction_id character varying(255) COLLATE pg_catalog."default",
    acronym character varying(255) COLLATE pg_catalog."default",
    dept_name character varying(255) COLLATE pg_catalog."default",
    external_id character varying(255) COLLATE pg_catalog."default" UNIQUE NOT NULL,
    created_date timestamp with time zone,
    created_by_user_id uuid,
    updated_date timestamp with time zone,
    updated_by_user_id uuid,
    CONSTRAINT fk_direction_id FOREIGN KEY (direction_id)
        REFERENCES master_data.direction (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
) WITH (
    OIDS = FALSE
) TABLESPACE pg_default;

ALTER TABLE master_data.mentor OWNER to master_data;
-- END master_data.mentor

-- CREATE master_data.student
CREATE TABLE master_data.student (
    id uuid PRIMARY KEY,
    first_name character varying(255) COLLATE pg_catalog."default",
    last_name character varying(255) COLLATE pg_catalog."default",
    email_address character varying(255) COLLATE pg_catalog."default",
    phone_number character varying(255) COLLATE pg_catalog."default",
    user_id uuid,
    direction_id uuid,
    ext_direction_id character varying(255) COLLATE pg_catalog."default",
    subdirection_id uuid,
    ext_subdirection_id character varying(255) COLLATE pg_catalog."default",
    external_id character varying(255) COLLATE pg_catalog."default" UNIQUE NOT NULL,
    year_of_study integer,
    semester integer,
    tech_comment text COLLATE pg_catalog."default",
    hr_comment text COLLATE pg_catalog."default",
    interviewer_id uuid,
    ext_interviewer_id character varying(255) COLLATE pg_catalog."default",
    created_date timestamp with time zone,
    created_by_user_id uuid,
    updated_date timestamp with time zone,
    updated_by_user_id uuid,
    CONSTRAINT fk_direction_id FOREIGN KEY (direction_id)
        REFERENCES master_data.direction (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT fk_interviewer_id FOREIGN KEY (interviewer_id)
        REFERENCES master_data.mentor (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fk_subdirection_id FOREIGN KEY (subdirection_id)
        REFERENCES master_data.subdirection (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
) WITH (
    OIDS = FALSE
) TABLESPACE pg_default;

ALTER TABLE master_data.student OWNER to master_data;
-- END master_data.student
-- END CREATE TABLES