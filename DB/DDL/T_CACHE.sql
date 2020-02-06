-- Table: project1.t_cache

-- DROP TABLE project1.t_cache;

CREATE TABLE project1.t_cache
(
    id character varying(50) COLLATE pg_catalog."default" NOT NULL,
    session_id character varying(50) COLLATE pg_catalog."default" NOT NULL,
    key character varying(100) COLLATE pg_catalog."default" NOT NULL,
    value character varying(4000) COLLATE pg_catalog."default",
    CONSTRAINT t_login_cache_pkey PRIMARY KEY (id),
    CONSTRAINT fk_session_id FOREIGN KEY (session_id)
        REFERENCES project1.t_login_session (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE project1.t_cache
    OWNER to postgres;