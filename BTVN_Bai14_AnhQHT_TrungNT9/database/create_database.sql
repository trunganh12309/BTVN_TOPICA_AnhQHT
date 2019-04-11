CREATE DATABASE jdbctestdb
  WITH OWNER = trunganh
       ENCODING = 'UTF8'
       TABLESPACE = pg_default
       LC_COLLATE = 'English_United States.1252'
       LC_CTYPE = 'English_United States.1252'
       CONNECTION LIMIT = -1;

CREATE TABLE person
(
  id serial NOT NULL,
  name character varying(50),
  CONSTRAINT person_pkey PRIMARY KEY (id)
)