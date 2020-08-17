--
-- PostgreSQL database dump
--

-- Dumped from database version 12.3
-- Dumped by pg_dump version 12.3

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
-- Name: app; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA app;


ALTER SCHEMA app OWNER TO postgres;

SET default_tablespace = '';

SET default_table_access_method = heap;
--
-- Name: t_list; Type: TABLE; Schema: app; Owner: postgres
--

CREATE TABLE app.t_list (
    list_id integer NOT NULL,
    title character varying(30),
    prio integer
);


ALTER TABLE app.t_list OWNER TO postgres;

--
-- Name: TABLE t_list; Type: COMMENT; Schema: app; Owner: postgres
--

COMMENT ON TABLE app.t_list IS 'リストテーブル';


--
-- Name: COLUMN t_list.list_id; Type: COMMENT; Schema: app; Owner: postgres
--

COMMENT ON COLUMN app.t_list.list_id IS 'リストID';


--
-- Name: COLUMN t_list.title; Type: COMMENT; Schema: app; Owner: postgres
--

COMMENT ON COLUMN app.t_list.title IS 'タイトル';


--
-- Name: COLUMN t_list.prio; Type: COMMENT; Schema: app; Owner: postgres
--

COMMENT ON COLUMN app.t_list.prio IS '表示順';


--
-- Name: t_list_list_id_seq; Type: SEQUENCE; Schema: app; Owner: postgres
--

CREATE SEQUENCE app.t_list_list_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE app.t_list_list_id_seq OWNER TO postgres;

--
-- Name: t_list_list_id_seq; Type: SEQUENCE OWNED BY; Schema: app; Owner: postgres
--

ALTER SEQUENCE app.t_list_list_id_seq OWNED BY app.t_list.list_id;


--
-- Name: t_todo; Type: TABLE; Schema: app; Owner: postgres
--

CREATE TABLE app.t_todo (
    todo_id integer NOT NULL,
    list_id integer NOT NULL,
    title character varying(30),
    body text,
    done boolean,
    limit_date_time timestamp without time zone,
    prio integer
);


ALTER TABLE app.t_todo OWNER TO postgres;

--
-- Name: TABLE t_todo; Type: COMMENT; Schema: app; Owner: postgres
--

COMMENT ON TABLE app.t_todo IS 'TODOテーブル';


--
-- Name: COLUMN t_todo.todo_id; Type: COMMENT; Schema: app; Owner: postgres
--

COMMENT ON COLUMN app.t_todo.todo_id IS 'TODOID';


--
-- Name: COLUMN t_todo.list_id; Type: COMMENT; Schema: app; Owner: postgres
--

COMMENT ON COLUMN app.t_todo.list_id IS 'リストID';


--
-- Name: COLUMN t_todo.title; Type: COMMENT; Schema: app; Owner: postgres
--

COMMENT ON COLUMN app.t_todo.title IS 'タイトル';


--
-- Name: COLUMN t_todo.body; Type: COMMENT; Schema: app; Owner: postgres
--

COMMENT ON COLUMN app.t_todo.body IS '本文';


--
-- Name: COLUMN t_todo.done; Type: COMMENT; Schema: app; Owner: postgres
--

COMMENT ON COLUMN app.t_todo.done IS '実施状況';


--
-- Name: COLUMN t_todo.limit_date_time; Type: COMMENT; Schema: app; Owner: postgres
--

COMMENT ON COLUMN app.t_todo.limit_date_time IS '期限';


--
-- Name: COLUMN t_todo.prio; Type: COMMENT; Schema: app; Owner: postgres
--

COMMENT ON COLUMN app.t_todo.prio IS '表示順';


--
-- Name: t_todo_todo_id_seq; Type: SEQUENCE; Schema: app; Owner: postgres
--

CREATE SEQUENCE app.t_todo_todo_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE app.t_todo_todo_id_seq OWNER TO postgres;

--
-- Name: t_todo_todo_id_seq; Type: SEQUENCE OWNED BY; Schema: app; Owner: postgres
--

ALTER SEQUENCE app.t_todo_todo_id_seq OWNED BY app.t_todo.todo_id;


--
-- Name: t_list list_id; Type: DEFAULT; Schema: app; Owner: postgres
--

ALTER TABLE ONLY app.t_list ALTER COLUMN list_id SET DEFAULT nextval('app.t_list_list_id_seq'::regclass);


--
-- Name: t_todo todo_id; Type: DEFAULT; Schema: app; Owner: postgres
--

ALTER TABLE ONLY app.t_todo ALTER COLUMN todo_id SET DEFAULT nextval('app.t_todo_todo_id_seq'::regclass);


--
-- Name: t_list t_list_pkey; Type: CONSTRAINT; Schema: app; Owner: postgres
--

ALTER TABLE ONLY app.t_list
    ADD CONSTRAINT t_list_pkey PRIMARY KEY (list_id);


--
-- Name: t_todo t_todo_pkey; Type: CONSTRAINT; Schema: app; Owner: postgres
--

ALTER TABLE ONLY app.t_todo
    ADD CONSTRAINT t_todo_pkey PRIMARY KEY (todo_id);


--
-- Name: t_todo t_todo_list_id_fkey; Type: FK CONSTRAINT; Schema: app; Owner: postgres
--

ALTER TABLE ONLY app.t_todo
    ADD CONSTRAINT t_todo_list_id_fkey FOREIGN KEY (list_id) REFERENCES app.t_list(list_id);


--
-- PostgreSQL database dump complete
--

