--
-- PostgreSQL database dump
--

-- Dumped from database version 11.3
-- Dumped by pg_dump version 11.3

-- Started on 2019-08-04 18:45:47

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 2828 (class 0 OID 16481)
-- Dependencies: 197
-- Data for Name: t_mt_usr_grp; Type: TABLE DATA; Schema: project1; Owner: postgres
--

COPY project1.t_mt_usr_grp (id, cd, name, description, dt_create, create_by, dt_update, update_by) FROM stdin;
C7A34A99159F240842492F4B20E8A599	ADM	Admin	Administrator Group	2019-05-18	SYS	\N	\N
9AD84B73AE329F7E503393C99AA83CF0	UL2	User Level 2	User Group Level 2	2019-05-18	SYS	\N	\N
433FAC435FF92F0CF3414AA155167BC9	UL1	User Level 1	User Group Level 1	2019-05-18	SYS	\N	\N
\.


-- Completed on 2019-08-04 18:45:48

--
-- PostgreSQL database dump complete
--

