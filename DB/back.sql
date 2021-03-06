toc.dat                                                                                             0000600 0004000 0002000 00000022722 13570204647 0014454 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        PGDMP       ;                
    w            project1    11.3    11.3 "    2           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                       false         3           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                       false         4           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                       false         5           1262    16393    project1    DATABASE     �   CREATE DATABASE project1 WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'English_United States.1252' LC_CTYPE = 'English_United States.1252';
    DROP DATABASE project1;
             postgres    false                     2615    16394    project1    SCHEMA        CREATE SCHEMA project1;
    DROP SCHEMA project1;
             postgres    false         �            1259    16488    seq_new_val    SEQUENCE     �   CREATE SEQUENCE project1.seq_new_val
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 999999999999999999
    CACHE 10;
 $   DROP SEQUENCE project1.seq_new_val;
       project1       postgres    false    6         �            1259    16716 	   t_app_cfg    TABLE     �   CREATE TABLE project1.t_app_cfg (
    id character varying(50) NOT NULL,
    key character varying(100) NOT NULL,
    value character varying(1000) NOT NULL
);
    DROP TABLE project1.t_app_cfg;
       project1         postgres    false    6         �            1259    16671    t_cache    TABLE     �   CREATE TABLE project1.t_cache (
    id character varying(50) NOT NULL,
    session_id character varying(50) NOT NULL,
    key character varying(100) NOT NULL,
    value character varying(4000)
);
    DROP TABLE project1.t_cache;
       project1         postgres    false    6         �            1259    16616    t_login_session    TABLE     f  CREATE TABLE project1.t_login_session (
    id character varying(50) NOT NULL,
    usr_id character varying(50) NOT NULL,
    dt_login timestamp(6) without time zone,
    token_duration integer NOT NULL,
    last_session_id character varying(50),
    channel character varying(50),
    ip_address character varying(50),
    is_active character varying(1)
);
 %   DROP TABLE project1.t_login_session;
       project1         postgres    false    6         �            1259    16481    t_mt_usr_grp    TABLE     A  CREATE TABLE project1.t_mt_usr_grp (
    id character varying(50) NOT NULL,
    cd character varying(50) NOT NULL,
    name character varying(50) NOT NULL,
    description character varying(100) NOT NULL,
    dt_create date,
    create_by character varying(50),
    dt_update date,
    update_by character varying(50)
);
 "   DROP TABLE project1.t_mt_usr_grp;
       project1         postgres    false    6         �            1259    16505    t_pwsd_vault    TABLE     d  CREATE TABLE project1.t_pwsd_vault (
    id character varying(50) NOT NULL,
    usr_id character varying(50) NOT NULL,
    location character varying(200) NOT NULL,
    usr_nm character varying(100),
    usr_pswd character varying(2000),
    dt_create date,
    create_by character varying(100),
    dt_update date,
    update_by character varying(100)
);
 "   DROP TABLE project1.t_pwsd_vault;
       project1         postgres    false    6         �            1259    16531    t_usr    TABLE     �  CREATE TABLE project1.t_usr (
    id character varying(50) NOT NULL,
    username character varying(100) NOT NULL,
    email character varying(200) NOT NULL,
    password character varying(2500) NOT NULL,
    fullname character varying(100) NOT NULL,
    usr_grp_id character varying(50) NOT NULL,
    dt_create date,
    create_by character varying(100),
    dt_update date,
    update_by character varying(100)
);
    DROP TABLE project1.t_usr;
       project1         postgres    false    6         �            1259    16521 	   t_usr_grp    TABLE     y   CREATE TABLE project1.t_usr_grp (
    id character varying(50) NOT NULL,
    mt_grp_id character varying(50) NOT NULL
);
    DROP TABLE project1.t_usr_grp;
       project1         postgres    false    6         �            1259    16486    seq_new_val    SEQUENCE     �   CREATE SEQUENCE public.seq_new_val
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 999999999999999999
    CACHE 10;
 "   DROP SEQUENCE public.seq_new_val;
       public       postgres    false         /          0    16716 	   t_app_cfg 
   TABLE DATA                     project1       postgres    false    205       2863.dat .          0    16671    t_cache 
   TABLE DATA                     project1       postgres    false    204       2862.dat -          0    16616    t_login_session 
   TABLE DATA                     project1       postgres    false    203       2861.dat '          0    16481    t_mt_usr_grp 
   TABLE DATA                     project1       postgres    false    197       2855.dat *          0    16505    t_pwsd_vault 
   TABLE DATA                     project1       postgres    false    200       2858.dat ,          0    16531    t_usr 
   TABLE DATA                     project1       postgres    false    202       2860.dat +          0    16521 	   t_usr_grp 
   TABLE DATA                     project1       postgres    false    201       2859.dat 6           0    0    seq_new_val    SEQUENCE SET     <   SELECT pg_catalog.setval('project1.seq_new_val', 10, true);
            project1       postgres    false    199         7           0    0    seq_new_val    SEQUENCE SET     :   SELECT pg_catalog.setval('public.seq_new_val', 1, false);
            public       postgres    false    198         �
           2606    16620 "   t_login_session pk_t_login_session 
   CONSTRAINT     b   ALTER TABLE ONLY project1.t_login_session
    ADD CONSTRAINT pk_t_login_session PRIMARY KEY (id);
 N   ALTER TABLE ONLY project1.t_login_session DROP CONSTRAINT pk_t_login_session;
       project1         postgres    false    203         �
           2606    16723    t_app_cfg t_app_cfg_pkey 
   CONSTRAINT     X   ALTER TABLE ONLY project1.t_app_cfg
    ADD CONSTRAINT t_app_cfg_pkey PRIMARY KEY (id);
 D   ALTER TABLE ONLY project1.t_app_cfg DROP CONSTRAINT t_app_cfg_pkey;
       project1         postgres    false    205         �
           2606    16678    t_cache t_login_cache_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY project1.t_cache
    ADD CONSTRAINT t_login_cache_pkey PRIMARY KEY (id);
 F   ALTER TABLE ONLY project1.t_cache DROP CONSTRAINT t_login_cache_pkey;
       project1         postgres    false    204         �
           2606    16485    t_mt_usr_grp t_mt_usr_grp_pkey 
   CONSTRAINT     ^   ALTER TABLE ONLY project1.t_mt_usr_grp
    ADD CONSTRAINT t_mt_usr_grp_pkey PRIMARY KEY (id);
 J   ALTER TABLE ONLY project1.t_mt_usr_grp DROP CONSTRAINT t_mt_usr_grp_pkey;
       project1         postgres    false    197         �
           2606    16512    t_pwsd_vault t_pwsd_vault_pkey 
   CONSTRAINT     ^   ALTER TABLE ONLY project1.t_pwsd_vault
    ADD CONSTRAINT t_pwsd_vault_pkey PRIMARY KEY (id);
 J   ALTER TABLE ONLY project1.t_pwsd_vault DROP CONSTRAINT t_pwsd_vault_pkey;
       project1         postgres    false    200         �
           2606    16525    t_usr_grp t_usr_grp_pk 
   CONSTRAINT     V   ALTER TABLE ONLY project1.t_usr_grp
    ADD CONSTRAINT t_usr_grp_pk PRIMARY KEY (id);
 B   ALTER TABLE ONLY project1.t_usr_grp DROP CONSTRAINT t_usr_grp_pk;
       project1         postgres    false    201         �
           2606    16538    t_usr t_usr_pk 
   CONSTRAINT     N   ALTER TABLE ONLY project1.t_usr
    ADD CONSTRAINT t_usr_pk PRIMARY KEY (id);
 :   ALTER TABLE ONLY project1.t_usr DROP CONSTRAINT t_usr_pk;
       project1         postgres    false    202         �
           2606    16526    t_usr_grp fk_mt_grp_id    FK CONSTRAINT     �   ALTER TABLE ONLY project1.t_usr_grp
    ADD CONSTRAINT fk_mt_grp_id FOREIGN KEY (mt_grp_id) REFERENCES project1.t_mt_usr_grp(id);
 B   ALTER TABLE ONLY project1.t_usr_grp DROP CONSTRAINT fk_mt_grp_id;
       project1       postgres    false    197    2717    201         �
           2606    16679    t_cache fk_session_id    FK CONSTRAINT     �   ALTER TABLE ONLY project1.t_cache
    ADD CONSTRAINT fk_session_id FOREIGN KEY (session_id) REFERENCES project1.t_login_session(id);
 A   ALTER TABLE ONLY project1.t_cache DROP CONSTRAINT fk_session_id;
       project1       postgres    false    2725    204    203         �
           2606    16539    t_usr fk_usr_grp_id    FK CONSTRAINT     }   ALTER TABLE ONLY project1.t_usr
    ADD CONSTRAINT fk_usr_grp_id FOREIGN KEY (usr_grp_id) REFERENCES project1.t_usr_grp(id);
 ?   ALTER TABLE ONLY project1.t_usr DROP CONSTRAINT fk_usr_grp_id;
       project1       postgres    false    201    202    2721         �
           2606    16621    t_login_session fk_usr_id    FK CONSTRAINT     {   ALTER TABLE ONLY project1.t_login_session
    ADD CONSTRAINT fk_usr_id FOREIGN KEY (usr_id) REFERENCES project1.t_usr(id);
 E   ALTER TABLE ONLY project1.t_login_session DROP CONSTRAINT fk_usr_id;
       project1       postgres    false    2723    202    203                                                      2863.dat                                                                                            0000600 0004000 0002000 00000000002 13570204647 0014254 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        

                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              2862.dat                                                                                            0000600 0004000 0002000 00000000002 13570204647 0014253 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        

                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              2861.dat                                                                                            0000600 0004000 0002000 00000052676 13570204647 0014302 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        INSERT INTO project1.t_login_session (id, usr_id, dt_login, token_duration, last_session_id, channel, ip_address, is_active) VALUES ('DCB40714D0AC468EA2020107A2533014', 'CF83B19ACFEF4A58AB0AF02BAF5CB747', '2019-11-16 15:13:28.06', 150, NULL, 'TEST', 'localhost', 'Y');
INSERT INTO project1.t_login_session (id, usr_id, dt_login, token_duration, last_session_id, channel, ip_address, is_active) VALUES ('A507A4FE6AF84D1D8E725F7870736233', 'CF83B19ACFEF4A58AB0AF02BAF5CB747', '2019-11-16 15:32:55.45', 150, NULL, 'TEST', 'localhost', 'Y');
INSERT INTO project1.t_login_session (id, usr_id, dt_login, token_duration, last_session_id, channel, ip_address, is_active) VALUES ('FD8A8E2B2F0244B5B17463C920FDC048', 'CF83B19ACFEF4A58AB0AF02BAF5CB747', '2019-11-16 15:33:48.193', 150, NULL, 'TEST', 'localhost', 'Y');
INSERT INTO project1.t_login_session (id, usr_id, dt_login, token_duration, last_session_id, channel, ip_address, is_active) VALUES ('30D477E5F877438F9B7985D53E651B57', 'CF83B19ACFEF4A58AB0AF02BAF5CB747', '2019-11-16 18:05:50.536', 150, NULL, 'TEST', 'localhost', 'Y');
INSERT INTO project1.t_login_session (id, usr_id, dt_login, token_duration, last_session_id, channel, ip_address, is_active) VALUES ('C9CDC53CAEB64453A893CABA11BE2380', 'CF83B19ACFEF4A58AB0AF02BAF5CB747', '2019-11-16 19:30:38.875', 150, NULL, 'TEST', 'localhost', 'Y');
INSERT INTO project1.t_login_session (id, usr_id, dt_login, token_duration, last_session_id, channel, ip_address, is_active) VALUES ('60677498682C4318BF9E95E611EBE1AF', 'CF83B19ACFEF4A58AB0AF02BAF5CB747', '2019-11-16 19:31:30.723', 150, NULL, 'TEST', 'localhost', 'Y');
INSERT INTO project1.t_login_session (id, usr_id, dt_login, token_duration, last_session_id, channel, ip_address, is_active) VALUES ('78658B3CF5B84CEE94C424B6813B49E0', 'CF83B19ACFEF4A58AB0AF02BAF5CB747', '2019-11-16 19:34:30.914', 150, NULL, 'TEST', 'localhost', 'Y');
INSERT INTO project1.t_login_session (id, usr_id, dt_login, token_duration, last_session_id, channel, ip_address, is_active) VALUES ('90366583291B4979992A104C7073BC2F', 'CF83B19ACFEF4A58AB0AF02BAF5CB747', '2019-11-16 19:51:48.939', 150, NULL, 'TEST', 'localhost', 'Y');
INSERT INTO project1.t_login_session (id, usr_id, dt_login, token_duration, last_session_id, channel, ip_address, is_active) VALUES ('0CA38FF989F547278E0944CA46D853A9', 'CF83B19ACFEF4A58AB0AF02BAF5CB747', '2019-11-17 13:36:34.074', 150, NULL, 'TEST', 'localhost', 'Y');
INSERT INTO project1.t_login_session (id, usr_id, dt_login, token_duration, last_session_id, channel, ip_address, is_active) VALUES ('C389C7A74D2D4A1EBEB0967D2278A3D3', 'CF83B19ACFEF4A58AB0AF02BAF5CB747', '2019-11-17 13:40:04.942', 150, NULL, 'TEST', 'localhost', 'Y');
INSERT INTO project1.t_login_session (id, usr_id, dt_login, token_duration, last_session_id, channel, ip_address, is_active) VALUES ('E4E079BD0B2646CC89F6BF6C526D1866', 'CF83B19ACFEF4A58AB0AF02BAF5CB747', '2019-11-17 13:41:06.861', 150, NULL, 'TEST', 'localhost', 'Y');
INSERT INTO project1.t_login_session (id, usr_id, dt_login, token_duration, last_session_id, channel, ip_address, is_active) VALUES ('E110544FBE814A24A575BF7938CDA063', 'CF83B19ACFEF4A58AB0AF02BAF5CB747', '2019-11-17 13:50:46.533', 150, NULL, 'TEST', 'localhost', 'Y');
INSERT INTO project1.t_login_session (id, usr_id, dt_login, token_duration, last_session_id, channel, ip_address, is_active) VALUES ('5614F602D23F4E42BB2D9A6A8DCC3FB0', 'CF83B19ACFEF4A58AB0AF02BAF5CB747', '2019-11-17 13:51:42.282', 150, NULL, 'TEST', 'localhost', 'Y');
INSERT INTO project1.t_login_session (id, usr_id, dt_login, token_duration, last_session_id, channel, ip_address, is_active) VALUES ('B4F6DAC979D54C379C46F686192F5CB7', 'CF83B19ACFEF4A58AB0AF02BAF5CB747', '2019-11-17 13:55:07.508', 150, NULL, 'TEST', 'localhost', 'Y');
INSERT INTO project1.t_login_session (id, usr_id, dt_login, token_duration, last_session_id, channel, ip_address, is_active) VALUES ('5B0441586BED4491AFEE67905A5A671A', 'CF83B19ACFEF4A58AB0AF02BAF5CB747', '2019-11-17 13:57:45.154', 150, NULL, 'TEST', 'localhost', 'Y');
INSERT INTO project1.t_login_session (id, usr_id, dt_login, token_duration, last_session_id, channel, ip_address, is_active) VALUES ('457AA459297E4DBDBDC43F551E2F9D76', 'CF83B19ACFEF4A58AB0AF02BAF5CB747', '2019-11-17 14:07:55.338', 150, NULL, 'TEST', 'localhost', 'Y');
INSERT INTO project1.t_login_session (id, usr_id, dt_login, token_duration, last_session_id, channel, ip_address, is_active) VALUES ('4DE2F895CDA24290980D0A47244FDF4D', 'CF83B19ACFEF4A58AB0AF02BAF5CB747', '2019-11-17 14:08:53.334', 150, NULL, 'TEST', 'localhost', 'Y');
INSERT INTO project1.t_login_session (id, usr_id, dt_login, token_duration, last_session_id, channel, ip_address, is_active) VALUES ('3956647B9A5B42818964EBD0ED64F40F', 'CF83B19ACFEF4A58AB0AF02BAF5CB747', '2019-11-17 14:10:43.406', 150, NULL, 'TEST', 'localhost', 'Y');
INSERT INTO project1.t_login_session (id, usr_id, dt_login, token_duration, last_session_id, channel, ip_address, is_active) VALUES ('3D9B17A236E64F21A4FB82BB54931E68', 'CF83B19ACFEF4A58AB0AF02BAF5CB747', '2019-11-17 14:12:03.349', 150, NULL, 'TEST', 'localhost', 'Y');
INSERT INTO project1.t_login_session (id, usr_id, dt_login, token_duration, last_session_id, channel, ip_address, is_active) VALUES ('1A9C4A3EC82545A498FB71B325AABEB5', 'CF83B19ACFEF4A58AB0AF02BAF5CB747', '2019-11-17 14:13:11.596', 150, NULL, 'TEST', 'localhost', 'Y');
INSERT INTO project1.t_login_session (id, usr_id, dt_login, token_duration, last_session_id, channel, ip_address, is_active) VALUES ('9C0496B7DF9842BDBE95564F88EB92AE', 'CF83B19ACFEF4A58AB0AF02BAF5CB747', '2019-11-17 20:08:51.37', 150, NULL, 'TEST', 'localhost', 'Y');
INSERT INTO project1.t_login_session (id, usr_id, dt_login, token_duration, last_session_id, channel, ip_address, is_active) VALUES ('03BA58F3AD314A639F446C201FED5A40', 'CF83B19ACFEF4A58AB0AF02BAF5CB747', '2019-11-17 20:11:33.817', 150, NULL, 'TEST', 'localhost', 'Y');
INSERT INTO project1.t_login_session (id, usr_id, dt_login, token_duration, last_session_id, channel, ip_address, is_active) VALUES ('F1E41638863E4F1EA7FEBCB9B786DCEC', 'CF83B19ACFEF4A58AB0AF02BAF5CB747', '2019-11-17 20:16:22.367', 150, NULL, 'TEST', 'localhost', 'Y');
INSERT INTO project1.t_login_session (id, usr_id, dt_login, token_duration, last_session_id, channel, ip_address, is_active) VALUES ('C0758D59FEE24921AA56DB99E25DFFCE', 'CF83B19ACFEF4A58AB0AF02BAF5CB747', '2019-11-17 20:17:15.756', 150, NULL, 'TEST', 'localhost', 'Y');
INSERT INTO project1.t_login_session (id, usr_id, dt_login, token_duration, last_session_id, channel, ip_address, is_active) VALUES ('8CB551A730614A15A6E2D0DE66069751', 'CF83B19ACFEF4A58AB0AF02BAF5CB747', '2019-11-17 20:29:30.37', 150, NULL, 'TEST', 'localhost', 'Y');
INSERT INTO project1.t_login_session (id, usr_id, dt_login, token_duration, last_session_id, channel, ip_address, is_active) VALUES ('D6733E90BF4B4B73A5ADD987F1028B6B', 'CF83B19ACFEF4A58AB0AF02BAF5CB747', '2019-11-17 20:32:48.855', 150, NULL, 'TEST', 'localhost', 'Y');
INSERT INTO project1.t_login_session (id, usr_id, dt_login, token_duration, last_session_id, channel, ip_address, is_active) VALUES ('6152D5160079484BACB58ED7537DF496', 'CF83B19ACFEF4A58AB0AF02BAF5CB747', '2019-11-17 20:34:35.265', 150, NULL, 'TEST', 'localhost', 'Y');
INSERT INTO project1.t_login_session (id, usr_id, dt_login, token_duration, last_session_id, channel, ip_address, is_active) VALUES ('2E56EC196E7C4D80BEE1D32145F7419D', 'CF83B19ACFEF4A58AB0AF02BAF5CB747', '2019-11-17 20:35:10.724', 150, NULL, 'TEST', 'localhost', 'Y');
INSERT INTO project1.t_login_session (id, usr_id, dt_login, token_duration, last_session_id, channel, ip_address, is_active) VALUES ('860C0018B35A4884888BD8502908A382', 'CF83B19ACFEF4A58AB0AF02BAF5CB747', '2019-11-17 20:47:09.812', 150, NULL, 'TEST', 'localhost', 'Y');
INSERT INTO project1.t_login_session (id, usr_id, dt_login, token_duration, last_session_id, channel, ip_address, is_active) VALUES ('A1C9F4032E424366BA4960BACBD256B6', 'CF83B19ACFEF4A58AB0AF02BAF5CB747', '2019-11-17 20:53:20.375', 150, NULL, 'TEST', 'localhost', 'Y');
INSERT INTO project1.t_login_session (id, usr_id, dt_login, token_duration, last_session_id, channel, ip_address, is_active) VALUES ('53820B01BD97455BA2BEB5BC13F8696C', 'CF83B19ACFEF4A58AB0AF02BAF5CB747', '2019-11-17 20:53:58.238', 150, NULL, 'TEST', 'localhost', 'Y');
INSERT INTO project1.t_login_session (id, usr_id, dt_login, token_duration, last_session_id, channel, ip_address, is_active) VALUES ('FE9C76D24717412AB859ECD069BDC0C6', 'CF83B19ACFEF4A58AB0AF02BAF5CB747', '2019-11-17 20:56:24.249', 150, NULL, 'TEST', 'localhost', 'Y');
INSERT INTO project1.t_login_session (id, usr_id, dt_login, token_duration, last_session_id, channel, ip_address, is_active) VALUES ('551EE051470044A6A4957F1CF620C83C', 'CF83B19ACFEF4A58AB0AF02BAF5CB747', '2019-11-17 21:01:32.016', 150, NULL, 'TEST', 'localhost', 'Y');
INSERT INTO project1.t_login_session (id, usr_id, dt_login, token_duration, last_session_id, channel, ip_address, is_active) VALUES ('CC65F5D7D564456DBD3648C76D1BF91D', 'CF83B19ACFEF4A58AB0AF02BAF5CB747', '2019-11-17 21:03:42.835', 150, NULL, 'TEST', 'localhost', 'Y');
INSERT INTO project1.t_login_session (id, usr_id, dt_login, token_duration, last_session_id, channel, ip_address, is_active) VALUES ('47829B8ACCAA4BCC9A969A25E23609F4', 'CF83B19ACFEF4A58AB0AF02BAF5CB747', '2019-11-18 22:24:02.777', 150, NULL, 'TEST', 'localhost', 'Y');
INSERT INTO project1.t_login_session (id, usr_id, dt_login, token_duration, last_session_id, channel, ip_address, is_active) VALUES ('BFD7438B5FA9498F8DDAF531E05137BF', 'CF83B19ACFEF4A58AB0AF02BAF5CB747', '2019-11-18 22:28:23.934', 150, NULL, 'TEST', 'localhost', 'Y');
INSERT INTO project1.t_login_session (id, usr_id, dt_login, token_duration, last_session_id, channel, ip_address, is_active) VALUES ('425065F1C6E04BA79E43FC79FF1DD05B', 'CF83B19ACFEF4A58AB0AF02BAF5CB747', '2019-11-18 22:29:45.577', 150, NULL, 'TEST', 'localhost', 'Y');
INSERT INTO project1.t_login_session (id, usr_id, dt_login, token_duration, last_session_id, channel, ip_address, is_active) VALUES ('48967D8FC6D24A72BFCCAC0C2BCEB5E6', 'CF83B19ACFEF4A58AB0AF02BAF5CB747', '2019-11-22 20:26:21.843', 150, NULL, 'TEST', 'localhost', 'Y');
INSERT INTO project1.t_login_session (id, usr_id, dt_login, token_duration, last_session_id, channel, ip_address, is_active) VALUES ('3F1ECCC7FA5944E2AE74A1EAFB98F31A', 'CF83B19ACFEF4A58AB0AF02BAF5CB747', '2019-11-22 20:35:56.192', 150, NULL, 'TEST', 'localhost', 'Y');
INSERT INTO project1.t_login_session (id, usr_id, dt_login, token_duration, last_session_id, channel, ip_address, is_active) VALUES ('CAEB9867F67F4D40BCEE9506B2B433A3', 'CF83B19ACFEF4A58AB0AF02BAF5CB747', '2019-11-22 20:42:46.341', 150, NULL, 'TEST', 'localhost', 'N');
INSERT INTO project1.t_login_session (id, usr_id, dt_login, token_duration, last_session_id, channel, ip_address, is_active) VALUES ('0DBB3A8F92644716ACAD9F86D8F32059', 'CF83B19ACFEF4A58AB0AF02BAF5CB747', '2019-11-22 20:43:00.278', 150, 'CAEB9867F67F4D40BCEE9506B2B433A3', 'TEST', 'localhost', 'Y');
INSERT INTO project1.t_login_session (id, usr_id, dt_login, token_duration, last_session_id, channel, ip_address, is_active) VALUES ('D396A7E9AF44430EA75CDBED627643C7', 'CF83B19ACFEF4A58AB0AF02BAF5CB747', '2019-11-22 20:44:14.313', 150, NULL, 'TEST', 'localhost', 'Y');
INSERT INTO project1.t_login_session (id, usr_id, dt_login, token_duration, last_session_id, channel, ip_address, is_active) VALUES ('51FCD42ED6364D96AE775F6786C6AFE1', 'CF83B19ACFEF4A58AB0AF02BAF5CB747', '2019-11-22 20:51:19.385', 150, NULL, 'TEST', 'localhost', 'N');
INSERT INTO project1.t_login_session (id, usr_id, dt_login, token_duration, last_session_id, channel, ip_address, is_active) VALUES ('5A0FCC4B13AE4C349F94114ECB0948DE', 'CF83B19ACFEF4A58AB0AF02BAF5CB747', '2019-11-22 20:51:32.843', 150, '51FCD42ED6364D96AE775F6786C6AFE1', 'TEST', 'localhost', 'Y');
INSERT INTO project1.t_login_session (id, usr_id, dt_login, token_duration, last_session_id, channel, ip_address, is_active) VALUES ('D04347D56C804B53A04C056BCBB87B9F', 'CF83B19ACFEF4A58AB0AF02BAF5CB747', '2019-11-22 20:52:16.439', 150, NULL, 'TEST', 'localhost', 'N');
INSERT INTO project1.t_login_session (id, usr_id, dt_login, token_duration, last_session_id, channel, ip_address, is_active) VALUES ('37A040FF4F07493C8249B5A82ACAA347', 'CF83B19ACFEF4A58AB0AF02BAF5CB747', '2019-11-22 20:52:59.119', 150, 'D04347D56C804B53A04C056BCBB87B9F', 'TEST', 'localhost', 'Y');
INSERT INTO project1.t_login_session (id, usr_id, dt_login, token_duration, last_session_id, channel, ip_address, is_active) VALUES ('B2F476808C8B4443AF91C7779BC0A6DD', 'CF83B19ACFEF4A58AB0AF02BAF5CB747', '2019-11-22 20:55:36.91', 150, NULL, 'TEST', 'localhost', 'N');
INSERT INTO project1.t_login_session (id, usr_id, dt_login, token_duration, last_session_id, channel, ip_address, is_active) VALUES ('1A4F5C6430724A2AB9A0B7F2893794F7', 'CF83B19ACFEF4A58AB0AF02BAF5CB747', '2019-11-22 20:55:47.847', 150, 'B2F476808C8B4443AF91C7779BC0A6DD', 'TEST', 'localhost', 'Y');
INSERT INTO project1.t_login_session (id, usr_id, dt_login, token_duration, last_session_id, channel, ip_address, is_active) VALUES ('12324758D3714370B3A151D5BEC2F36E', 'CF83B19ACFEF4A58AB0AF02BAF5CB747', '2019-11-22 21:00:17.457', 150, NULL, 'TEST', 'localhost', 'N');
INSERT INTO project1.t_login_session (id, usr_id, dt_login, token_duration, last_session_id, channel, ip_address, is_active) VALUES ('70FFE832357D45EB8681325EC6F16159', 'CF83B19ACFEF4A58AB0AF02BAF5CB747', '2019-11-22 21:00:42.756', 150, '12324758D3714370B3A151D5BEC2F36E', 'TEST', 'localhost', 'Y');
INSERT INTO project1.t_login_session (id, usr_id, dt_login, token_duration, last_session_id, channel, ip_address, is_active) VALUES ('9DD5F4344F644AA3A1917BDBD022BF31', 'CF83B19ACFEF4A58AB0AF02BAF5CB747', '2019-11-22 21:02:12.001', 150, NULL, 'TEST', 'localhost', 'N');
INSERT INTO project1.t_login_session (id, usr_id, dt_login, token_duration, last_session_id, channel, ip_address, is_active) VALUES ('268D7564FDF34E4BA37DA6DDBD7AECB7', 'CF83B19ACFEF4A58AB0AF02BAF5CB747', '2019-11-22 21:02:21.934', 150, '9DD5F4344F644AA3A1917BDBD022BF31', 'TEST', 'localhost', 'Y');
INSERT INTO project1.t_login_session (id, usr_id, dt_login, token_duration, last_session_id, channel, ip_address, is_active) VALUES ('FEE86B8369874FA49259EA04C0DB9AC4', 'CF83B19ACFEF4A58AB0AF02BAF5CB747', '2019-11-22 21:02:59.532', 150, NULL, 'TEST', 'localhost', 'N');
INSERT INTO project1.t_login_session (id, usr_id, dt_login, token_duration, last_session_id, channel, ip_address, is_active) VALUES ('3F29A959F44046FBAAA7394649DA5A67', 'CF83B19ACFEF4A58AB0AF02BAF5CB747', '2019-11-22 21:03:07.6', 150, 'FEE86B8369874FA49259EA04C0DB9AC4', 'TEST', 'localhost', 'Y');
INSERT INTO project1.t_login_session (id, usr_id, dt_login, token_duration, last_session_id, channel, ip_address, is_active) VALUES ('297C9D9543D14299840B6CF4C0D03B2B', 'CF83B19ACFEF4A58AB0AF02BAF5CB747', '2019-11-22 21:05:35.176', 150, NULL, 'TEST', 'localhost', 'N');
INSERT INTO project1.t_login_session (id, usr_id, dt_login, token_duration, last_session_id, channel, ip_address, is_active) VALUES ('26DFEBA177244C9F830B408EABDF8236', 'CF83B19ACFEF4A58AB0AF02BAF5CB747', '2019-11-22 21:05:56.101', 150, '297C9D9543D14299840B6CF4C0D03B2B', 'TEST', 'localhost', 'Y');
INSERT INTO project1.t_login_session (id, usr_id, dt_login, token_duration, last_session_id, channel, ip_address, is_active) VALUES ('28D74C5F1EEC41F481929A08C750ADA0', 'CF83B19ACFEF4A58AB0AF02BAF5CB747', '2019-11-22 21:12:25.38', 150, NULL, 'TEST', 'localhost', 'N');
INSERT INTO project1.t_login_session (id, usr_id, dt_login, token_duration, last_session_id, channel, ip_address, is_active) VALUES ('C58EB82629B3484294F51496BD4626B5', 'CF83B19ACFEF4A58AB0AF02BAF5CB747', '2019-11-22 21:12:49.234', 150, '28D74C5F1EEC41F481929A08C750ADA0', 'TEST', 'localhost', 'Y');
INSERT INTO project1.t_login_session (id, usr_id, dt_login, token_duration, last_session_id, channel, ip_address, is_active) VALUES ('C76B77E3743A426AAF1F315DD9B3DC18', 'CF83B19ACFEF4A58AB0AF02BAF5CB747', '2019-11-23 21:26:56.05', 150, NULL, 'TEST', 'localhost', 'N');
INSERT INTO project1.t_login_session (id, usr_id, dt_login, token_duration, last_session_id, channel, ip_address, is_active) VALUES ('F69A077209C4487EAA279AC9667FA00A', 'CF83B19ACFEF4A58AB0AF02BAF5CB747', '2019-11-23 21:27:39.757', 150, 'C76B77E3743A426AAF1F315DD9B3DC18', 'TEST', 'localhost', 'Y');
INSERT INTO project1.t_login_session (id, usr_id, dt_login, token_duration, last_session_id, channel, ip_address, is_active) VALUES ('F29AC0E023A245FE8F2A4C346DD0F260', 'CF83B19ACFEF4A58AB0AF02BAF5CB747', '2019-11-23 21:28:25.757', 150, NULL, 'TEST', 'localhost', 'N');
INSERT INTO project1.t_login_session (id, usr_id, dt_login, token_duration, last_session_id, channel, ip_address, is_active) VALUES ('C0EE41638A39415994E8A22553E8E6C0', 'CF83B19ACFEF4A58AB0AF02BAF5CB747', '2019-11-23 21:29:19.436', 150, 'F29AC0E023A245FE8F2A4C346DD0F260', 'TEST', 'localhost', 'Y');
INSERT INTO project1.t_login_session (id, usr_id, dt_login, token_duration, last_session_id, channel, ip_address, is_active) VALUES ('60D77BDE8CBE4A80999E730A5BDD1AA2', 'CF83B19ACFEF4A58AB0AF02BAF5CB747', '2019-11-23 21:37:59.409', 150, NULL, 'TEST', 'localhost', 'N');
INSERT INTO project1.t_login_session (id, usr_id, dt_login, token_duration, last_session_id, channel, ip_address, is_active) VALUES ('C30751460C5C428293E958BB475ABA95', 'CF83B19ACFEF4A58AB0AF02BAF5CB747', '2019-11-23 21:38:29.143', 150, '60D77BDE8CBE4A80999E730A5BDD1AA2', 'TEST', 'localhost', 'N');
INSERT INTO project1.t_login_session (id, usr_id, dt_login, token_duration, last_session_id, channel, ip_address, is_active) VALUES ('E4F9B514F2FB4AF7B59D98D77C3D3EAD', 'CF83B19ACFEF4A58AB0AF02BAF5CB747', '2019-11-23 21:39:09.633', 150, 'C30751460C5C428293E958BB475ABA95', 'TEST', 'localhost', 'Y');
INSERT INTO project1.t_login_session (id, usr_id, dt_login, token_duration, last_session_id, channel, ip_address, is_active) VALUES ('A99CD32051AE4479837A799464BD1066', 'CF83B19ACFEF4A58AB0AF02BAF5CB747', '2019-11-24 11:08:25.34', 150, NULL, 'TEST', 'localhost', 'N');
INSERT INTO project1.t_login_session (id, usr_id, dt_login, token_duration, last_session_id, channel, ip_address, is_active) VALUES ('A55267F3AFCD427087914906297C01E2', 'CF83B19ACFEF4A58AB0AF02BAF5CB747', '2019-11-24 11:08:32.959', 150, 'A99CD32051AE4479837A799464BD1066', 'TEST', 'localhost', 'N');
INSERT INTO project1.t_login_session (id, usr_id, dt_login, token_duration, last_session_id, channel, ip_address, is_active) VALUES ('AC1E511A44A74E56BC070108A88DA818', 'CF83B19ACFEF4A58AB0AF02BAF5CB747', '2019-11-24 11:08:44.174', 150, 'A55267F3AFCD427087914906297C01E2', 'TEST', 'localhost', 'Y');
INSERT INTO project1.t_login_session (id, usr_id, dt_login, token_duration, last_session_id, channel, ip_address, is_active) VALUES ('9788B82D68E645EBB60FA6BE130A039B', 'CF83B19ACFEF4A58AB0AF02BAF5CB747', '2019-11-24 12:48:24.53', 150, NULL, 'TEST', 'localhost', 'N');
INSERT INTO project1.t_login_session (id, usr_id, dt_login, token_duration, last_session_id, channel, ip_address, is_active) VALUES ('74192FFD0E3343839DE9AD258595A0BE', 'CF83B19ACFEF4A58AB0AF02BAF5CB747', '2019-11-24 12:50:47.38', 150, '9788B82D68E645EBB60FA6BE130A039B', 'TEST', 'localhost', 'Y');
INSERT INTO project1.t_login_session (id, usr_id, dt_login, token_duration, last_session_id, channel, ip_address, is_active) VALUES ('705A068349F54BB2A29DDB1D7EAD81BB', 'CF83B19ACFEF4A58AB0AF02BAF5CB747', '2019-11-24 13:00:37.055', 150, NULL, 'TEST', 'localhost', 'N');
INSERT INTO project1.t_login_session (id, usr_id, dt_login, token_duration, last_session_id, channel, ip_address, is_active) VALUES ('ADEB4A5F02A24E9183E173E6DCD915EE', 'CF83B19ACFEF4A58AB0AF02BAF5CB747', '2019-11-24 13:00:43.595', 150, '705A068349F54BB2A29DDB1D7EAD81BB', 'TEST', 'localhost', 'Y');
INSERT INTO project1.t_login_session (id, usr_id, dt_login, token_duration, last_session_id, channel, ip_address, is_active) VALUES ('416880B6441944A59753C2422E15BB33', 'CF83B19ACFEF4A58AB0AF02BAF5CB747', '2019-11-24 13:01:08.117', 150, NULL, 'TEST', 'localhost', 'N');
INSERT INTO project1.t_login_session (id, usr_id, dt_login, token_duration, last_session_id, channel, ip_address, is_active) VALUES ('FC615CF7B98C4E4F830A05346D0087D6', 'CF83B19ACFEF4A58AB0AF02BAF5CB747', '2019-11-24 13:01:24.217', 150, '416880B6441944A59753C2422E15BB33', 'TEST', 'localhost', 'Y');
INSERT INTO project1.t_login_session (id, usr_id, dt_login, token_duration, last_session_id, channel, ip_address, is_active) VALUES ('2C1BC930766F4E499ECD032455E4A523', 'CF83B19ACFEF4A58AB0AF02BAF5CB747', '2019-11-24 14:28:06.693', 150, NULL, 'TEST', 'localhost', 'N');
INSERT INTO project1.t_login_session (id, usr_id, dt_login, token_duration, last_session_id, channel, ip_address, is_active) VALUES ('12DF25953D2A443FB499E23EC5CE84DB', 'CF83B19ACFEF4A58AB0AF02BAF5CB747', '2019-11-24 14:28:11.646', 150, '2C1BC930766F4E499ECD032455E4A523', 'TEST', 'localhost', 'Y');
INSERT INTO project1.t_login_session (id, usr_id, dt_login, token_duration, last_session_id, channel, ip_address, is_active) VALUES ('206A33ACC8E64DECA2C4BF83C1A50C97', 'CF83B19ACFEF4A58AB0AF02BAF5CB747', '2019-11-24 16:02:11.319', 150, NULL, 'TEST', 'localhost', 'N');
INSERT INTO project1.t_login_session (id, usr_id, dt_login, token_duration, last_session_id, channel, ip_address, is_active) VALUES ('9E87D221FB654E2CA6BE70285BF49FDB', 'CF83B19ACFEF4A58AB0AF02BAF5CB747', '2019-11-24 16:02:17.974', 150, '206A33ACC8E64DECA2C4BF83C1A50C97', 'TEST', 'localhost', 'N');
INSERT INTO project1.t_login_session (id, usr_id, dt_login, token_duration, last_session_id, channel, ip_address, is_active) VALUES ('493D2305671E4B4DB7220D467702EB74', 'CF83B19ACFEF4A58AB0AF02BAF5CB747', '2019-11-24 16:02:41.268', 150, '9E87D221FB654E2CA6BE70285BF49FDB', 'TEST', 'localhost', 'Y');


                                                                  2855.dat                                                                                            0000600 0004000 0002000 00000001253 13570204647 0014266 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        INSERT INTO project1.t_mt_usr_grp (id, cd, name, description, dt_create, create_by, dt_update, update_by) VALUES ('C7A34A99159F240842492F4B20E8A599', 'ADM', 'Admin', 'Administrator Group', '2019-05-18', 'SYS', NULL, NULL);
INSERT INTO project1.t_mt_usr_grp (id, cd, name, description, dt_create, create_by, dt_update, update_by) VALUES ('9AD84B73AE329F7E503393C99AA83CF0', 'UL2', 'User Level 2', 'User Group Level 2', '2019-05-18', 'SYS', NULL, NULL);
INSERT INTO project1.t_mt_usr_grp (id, cd, name, description, dt_create, create_by, dt_update, update_by) VALUES ('433FAC435FF92F0CF3414AA155167BC9', 'UL1', 'User Level 1', 'User Group Level 1', '2019-05-18', 'SYS', NULL, NULL);


                                                                                                                                                                                                                                                                                                                                                     2858.dat                                                                                            0000600 0004000 0002000 00000000402 13570204647 0014264 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        INSERT INTO project1.t_pwsd_vault (id, usr_id, location, usr_nm, usr_pswd, dt_create, create_by, dt_update, update_by) VALUES ('41AEDDA0CBE240CE8489288E5BFE4EC0', 'CF83B19ACFEF4A58AB0AF02BAF5CB747', 'TEST', 'TESTUSER', 'TESTPASS', NULL, NULL, NULL, NULL);


                                                                                                                                                                                                                                                              2860.dat                                                                                            0000600 0004000 0002000 00000000477 13570204647 0014271 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        INSERT INTO project1.t_usr (id, username, email, password, fullname, usr_grp_id, dt_create, create_by, dt_update, update_by) VALUES ('CF83B19ACFEF4A58AB0AF02BAF5CB747', 'faridrakh', 'faridrakh@yahoo.com', '123456789', 'Farid Rakhman Barus', '80230E11A09F41C2B5F9AACCD2AF2604', '2019-11-16', 'faridrakh', NULL, NULL);


                                                                                                                                                                                                 2859.dat                                                                                            0000600 0004000 0002000 00000000202 13570204647 0014263 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        INSERT INTO project1.t_usr_grp (id, mt_grp_id) VALUES ('80230E11A09F41C2B5F9AACCD2AF2604', '433FAC435FF92F0CF3414AA155167BC9');


                                                                                                                                                                                                                                                                                                                                                                                              restore.sql                                                                                         0000600 0004000 0002000 00000017677 13570204647 0015416 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        --
-- NOTE:
--
-- File paths need to be edited. Search for $$PATH$$ and
-- replace it with the path to the directory containing
-- the extracted data files.
--
--
-- PostgreSQL database dump
--

-- Dumped from database version 11.3
-- Dumped by pg_dump version 11.3

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

DROP DATABASE project1;
--
-- Name: project1; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE project1 WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'English_United States.1252' LC_CTYPE = 'English_United States.1252';


ALTER DATABASE project1 OWNER TO postgres;

\connect project1

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
-- Name: project1; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA project1;


ALTER SCHEMA project1 OWNER TO postgres;

--
-- Name: seq_new_val; Type: SEQUENCE; Schema: project1; Owner: postgres
--

CREATE SEQUENCE project1.seq_new_val
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 999999999999999999
    CACHE 10;


ALTER TABLE project1.seq_new_val OWNER TO postgres;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: t_app_cfg; Type: TABLE; Schema: project1; Owner: postgres
--

CREATE TABLE project1.t_app_cfg (
    id character varying(50) NOT NULL,
    key character varying(100) NOT NULL,
    value character varying(1000) NOT NULL
);


ALTER TABLE project1.t_app_cfg OWNER TO postgres;

--
-- Name: t_cache; Type: TABLE; Schema: project1; Owner: postgres
--

CREATE TABLE project1.t_cache (
    id character varying(50) NOT NULL,
    session_id character varying(50) NOT NULL,
    key character varying(100) NOT NULL,
    value character varying(4000)
);


ALTER TABLE project1.t_cache OWNER TO postgres;

--
-- Name: t_login_session; Type: TABLE; Schema: project1; Owner: postgres
--

CREATE TABLE project1.t_login_session (
    id character varying(50) NOT NULL,
    usr_id character varying(50) NOT NULL,
    dt_login timestamp(6) without time zone,
    token_duration integer NOT NULL,
    last_session_id character varying(50),
    channel character varying(50),
    ip_address character varying(50),
    is_active character varying(1)
);


ALTER TABLE project1.t_login_session OWNER TO postgres;

--
-- Name: t_mt_usr_grp; Type: TABLE; Schema: project1; Owner: postgres
--

CREATE TABLE project1.t_mt_usr_grp (
    id character varying(50) NOT NULL,
    cd character varying(50) NOT NULL,
    name character varying(50) NOT NULL,
    description character varying(100) NOT NULL,
    dt_create date,
    create_by character varying(50),
    dt_update date,
    update_by character varying(50)
);


ALTER TABLE project1.t_mt_usr_grp OWNER TO postgres;

--
-- Name: t_pwsd_vault; Type: TABLE; Schema: project1; Owner: postgres
--

CREATE TABLE project1.t_pwsd_vault (
    id character varying(50) NOT NULL,
    usr_id character varying(50) NOT NULL,
    location character varying(200) NOT NULL,
    usr_nm character varying(100),
    usr_pswd character varying(2000),
    dt_create date,
    create_by character varying(100),
    dt_update date,
    update_by character varying(100)
);


ALTER TABLE project1.t_pwsd_vault OWNER TO postgres;

--
-- Name: t_usr; Type: TABLE; Schema: project1; Owner: postgres
--

CREATE TABLE project1.t_usr (
    id character varying(50) NOT NULL,
    username character varying(100) NOT NULL,
    email character varying(200) NOT NULL,
    password character varying(2500) NOT NULL,
    fullname character varying(100) NOT NULL,
    usr_grp_id character varying(50) NOT NULL,
    dt_create date,
    create_by character varying(100),
    dt_update date,
    update_by character varying(100)
);


ALTER TABLE project1.t_usr OWNER TO postgres;

--
-- Name: t_usr_grp; Type: TABLE; Schema: project1; Owner: postgres
--

CREATE TABLE project1.t_usr_grp (
    id character varying(50) NOT NULL,
    mt_grp_id character varying(50) NOT NULL
);


ALTER TABLE project1.t_usr_grp OWNER TO postgres;

--
-- Name: seq_new_val; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.seq_new_val
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 999999999999999999
    CACHE 10;


ALTER TABLE public.seq_new_val OWNER TO postgres;

--
-- Data for Name: t_app_cfg; Type: TABLE DATA; Schema: project1; Owner: postgres
--

\i $$PATH$$/2863.dat

--
-- Data for Name: t_cache; Type: TABLE DATA; Schema: project1; Owner: postgres
--

\i $$PATH$$/2862.dat

--
-- Data for Name: t_login_session; Type: TABLE DATA; Schema: project1; Owner: postgres
--

\i $$PATH$$/2861.dat

--
-- Data for Name: t_mt_usr_grp; Type: TABLE DATA; Schema: project1; Owner: postgres
--

\i $$PATH$$/2855.dat

--
-- Data for Name: t_pwsd_vault; Type: TABLE DATA; Schema: project1; Owner: postgres
--

\i $$PATH$$/2858.dat

--
-- Data for Name: t_usr; Type: TABLE DATA; Schema: project1; Owner: postgres
--

\i $$PATH$$/2860.dat

--
-- Data for Name: t_usr_grp; Type: TABLE DATA; Schema: project1; Owner: postgres
--

\i $$PATH$$/2859.dat

--
-- Name: seq_new_val; Type: SEQUENCE SET; Schema: project1; Owner: postgres
--

SELECT pg_catalog.setval('project1.seq_new_val', 10, true);


--
-- Name: seq_new_val; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.seq_new_val', 1, false);


--
-- Name: t_login_session pk_t_login_session; Type: CONSTRAINT; Schema: project1; Owner: postgres
--

ALTER TABLE ONLY project1.t_login_session
    ADD CONSTRAINT pk_t_login_session PRIMARY KEY (id);


--
-- Name: t_app_cfg t_app_cfg_pkey; Type: CONSTRAINT; Schema: project1; Owner: postgres
--

ALTER TABLE ONLY project1.t_app_cfg
    ADD CONSTRAINT t_app_cfg_pkey PRIMARY KEY (id);


--
-- Name: t_cache t_login_cache_pkey; Type: CONSTRAINT; Schema: project1; Owner: postgres
--

ALTER TABLE ONLY project1.t_cache
    ADD CONSTRAINT t_login_cache_pkey PRIMARY KEY (id);


--
-- Name: t_mt_usr_grp t_mt_usr_grp_pkey; Type: CONSTRAINT; Schema: project1; Owner: postgres
--

ALTER TABLE ONLY project1.t_mt_usr_grp
    ADD CONSTRAINT t_mt_usr_grp_pkey PRIMARY KEY (id);


--
-- Name: t_pwsd_vault t_pwsd_vault_pkey; Type: CONSTRAINT; Schema: project1; Owner: postgres
--

ALTER TABLE ONLY project1.t_pwsd_vault
    ADD CONSTRAINT t_pwsd_vault_pkey PRIMARY KEY (id);


--
-- Name: t_usr_grp t_usr_grp_pk; Type: CONSTRAINT; Schema: project1; Owner: postgres
--

ALTER TABLE ONLY project1.t_usr_grp
    ADD CONSTRAINT t_usr_grp_pk PRIMARY KEY (id);


--
-- Name: t_usr t_usr_pk; Type: CONSTRAINT; Schema: project1; Owner: postgres
--

ALTER TABLE ONLY project1.t_usr
    ADD CONSTRAINT t_usr_pk PRIMARY KEY (id);


--
-- Name: t_usr_grp fk_mt_grp_id; Type: FK CONSTRAINT; Schema: project1; Owner: postgres
--

ALTER TABLE ONLY project1.t_usr_grp
    ADD CONSTRAINT fk_mt_grp_id FOREIGN KEY (mt_grp_id) REFERENCES project1.t_mt_usr_grp(id);


--
-- Name: t_cache fk_session_id; Type: FK CONSTRAINT; Schema: project1; Owner: postgres
--

ALTER TABLE ONLY project1.t_cache
    ADD CONSTRAINT fk_session_id FOREIGN KEY (session_id) REFERENCES project1.t_login_session(id);


--
-- Name: t_usr fk_usr_grp_id; Type: FK CONSTRAINT; Schema: project1; Owner: postgres
--

ALTER TABLE ONLY project1.t_usr
    ADD CONSTRAINT fk_usr_grp_id FOREIGN KEY (usr_grp_id) REFERENCES project1.t_usr_grp(id);


--
-- Name: t_login_session fk_usr_id; Type: FK CONSTRAINT; Schema: project1; Owner: postgres
--

ALTER TABLE ONLY project1.t_login_session
    ADD CONSTRAINT fk_usr_id FOREIGN KEY (usr_id) REFERENCES project1.t_usr(id);


--
-- PostgreSQL database dump complete
--

                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 