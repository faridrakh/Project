1. Create a sequence 
CREATE SEQUENCE project1.seq_new_val
INCREMENT 1
MINVALUE 1
MAXVALUE 999999999999999999
START 1
CACHE 10;



2. Generate the value

select md5(clock_timestamp()::text||random()::text||nextval('project1.seq_new_val'))
