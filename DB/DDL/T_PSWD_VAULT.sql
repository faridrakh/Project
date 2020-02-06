DROP TABLE project1.t_pwsd_vault;

CREATE TABLE project1.t_pwsd_vault
(
    id character varying(50) COLLATE pg_catalog."default" NOT NULL,
    usr_id character varying(50) COLLATE pg_catalog."default" NOT NULL,
    location character varying(200) COLLATE pg_catalog."default" NOT NULL,
    usr_nm character varying(100) COLLATE pg_catalog."default",
    usr_pswd character varying(2000) COLLATE pg_catalog."default",
	dt_create date,
    create_by character varying(100) COLLATE pg_catalog."default",
    dt_update date,
    update_by character varying(100) COLLATE pg_catalog."default",
    CONSTRAINT t_pwsd_vault_pkey PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE project1.t_pwsd_vault
    OWNER to postgres;
	
GRANT ALL ON TABLE project1.t_pwsd_vault TO postgres;
