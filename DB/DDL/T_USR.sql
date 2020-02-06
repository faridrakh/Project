DROP TABLE project1.t_usr;

CREATE TABLE project1.t_usr
(
    id character varying(50) COLLATE pg_catalog."default" NOT NULL,
    username character varying(100) COLLATE pg_catalog."default" NOT NULL,
    email character varying(200) COLLATE pg_catalog."default" NOT NULL,
    password character varying(2500) COLLATE pg_catalog."default" NOT NULL,
    fullname character varying(100) COLLATE pg_catalog."default" NOT NULL,
    usr_grp_id character varying(50) COLLATE pg_catalog."default" NOT NULL,
    dt_create date,
    create_by character varying(100) COLLATE pg_catalog."default",
    dt_update date,
    update_by character varying(100) COLLATE pg_catalog."default",
    CONSTRAINT t_usr_pk PRIMARY KEY (id),
    CONSTRAINT fk_usr_grp_id FOREIGN KEY (usr_grp_id)
        REFERENCES project1.t_usr_grp (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE project1.t_usr
    OWNER to postgres;

GRANT ALL ON TABLE project1.t_usr TO postgres;
