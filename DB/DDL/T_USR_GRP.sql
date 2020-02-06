DROP TABLE project1.t_usr_grp;

CREATE TABLE project1.t_usr_grp
(
    id character varying(50) NOT NULL,
    mt_grp_id character varying(50) NOT NULL,
    CONSTRAINT t_usr_grp_pk PRIMARY KEY (id),
    CONSTRAINT fk_mt_grp_id FOREIGN KEY (mt_grp_id)
        REFERENCES project1.t_mt_usr_grp (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
) TABLESPACE pg_default;

ALTER TABLE project1.t_usr_grp
    OWNER to postgres;

GRANT ALL ON TABLE project1.t_usr_grp TO postgres;
