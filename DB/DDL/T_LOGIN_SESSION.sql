-- Table: project1.t_login_session

DROP TABLE project1.t_login_session;

CREATE TABLE project1.t_login_session
(
    id character varying(50) COLLATE pg_catalog."default" NOT NULL,
    usr_id character varying(50) COLLATE pg_catalog."default" NOT NULL,
    dt_login timestamp(6) without time zone,
    token_duration integer NOT NULL,
    last_session_id character varying(50) COLLATE pg_catalog."default",
    channel character varying(50) COLLATE pg_catalog."default",
    ip_address character varying(50) COLLATE pg_catalog."default",
	is_active character varying(1) COLLATE pg_catalog."default",
    CONSTRAINT pk_t_login_session PRIMARY KEY (id),
    CONSTRAINT fk_usr_id FOREIGN KEY (usr_id)
        REFERENCES project1.t_usr (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE project1.t_login_session
    OWNER to postgres;

GRANT ALL ON TABLE project1.t_login_session TO postgres;