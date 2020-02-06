DROP TABLE project1.t_mt_usr_grp;

CREATE TABLE project1.t_mt_usr_grp
(
    id character varying(50) COLLATE pg_catalog."default" NOT NULL,
    cd character varying(50) COLLATE pg_catalog."default" NOT NULL,
    name character varying(50) COLLATE pg_catalog."default" NOT NULL,
    description character varying(100) COLLATE pg_catalog."default" NOT NULL,
    dt_create date,
    create_by character varying(50) COLLATE pg_catalog."default",
    dt_update date,
    update_by character varying(50) COLLATE pg_catalog."default",
    CONSTRAINT t_mt_usr_grp_pkey PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE project1.t_mt_usr_grp
    OWNER to postgres;

GRANT ALL ON TABLE project1.t_mt_usr_grp TO postgres;



INSERT INTO project1.t_mt_usr_grp(
	id, cd, name, description, dt_create, create_by, dt_update, update_by)
	VALUES (upper(md5(clock_timestamp()::text||random()::text||nextval('project1.uuid_seq'))), 'ADM', 'Admin', 
																	   'Administrator Group', current_date, 'SYS', NULL, NULL);

INSERT INTO project1.t_mt_usr_grp(
	id, cd, name, description, dt_create, create_by, dt_update, update_by)
	VALUES (upper(md5(clock_timestamp()::text||random()::text||nextval('project1.uuid_seq'))), 'UL2', 'User Level 2', 
																	   'User Group Level 2', current_date, 'SYS', NULL, NULL);
					  
INSERT INTO project1.t_mt_usr_grp(
	id, cd, name, description, dt_create, create_by, dt_update, update_by)
	VALUES (upper(md5(clock_timestamp()::text||random()::text||nextval('project1.uuid_seq'))), 'UL1', 'User Level 1', 
																	   'User Group Level 1', current_date, 'SYS', NULL, NULL);
